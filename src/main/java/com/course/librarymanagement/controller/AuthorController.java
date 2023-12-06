package com.course.librarymanagement.controller;

import com.course.librarymanagement.entity.Author;
import com.course.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model){
        model.addAttribute("authors",authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String removeAuthorById(@PathVariable Long id, Model model) {
        authorService.removeAuthorById(id);
        model.addAttribute("authors",authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/add-author")
    public String createAuthor(Author author, Model model) {
        model.addAttribute("authors",authorService.findAllAuthors());
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("authors",authorService.findAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id,Model model) {
        model.addAttribute("author",authorService.findAuthorsById(id));
        return "update-author";

    }

    @PostMapping("/update-author/{id}")
    public String saveAuthor(@PathVariable Long id, Author author, Model model , BindingResult result) {
        if (result.hasErrors()){
            return "update-author";
        }
        authorService.updateAuthor(author);
        model.addAttribute("author",authorService.findAllAuthors());
        return "redirect:/authors";
    }
}
