package com.course.librarymanagement.controller;

import com.course.librarymanagement.entity.Publisher;
import com.course.librarymanagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model){
        model.addAttribute("publishers",publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String removePublisherById(@PathVariable Long id, Model model) {
        publisherService.removePublisherById(id);
        model.addAttribute("publishers",publisherService.findAllPublishers());
        return "publishers";
    }
    @GetMapping("/add-publisher")
    public String createPublisher(Publisher publisher, Model model) {
        model.addAttribute("publishers",publisherService.findAllPublishers());
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers",publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id,Model model) {
        model.addAttribute("publisher",publisherService.findPublishersById(id));
        return "update-publisher";

    }

    @PostMapping("/update-publisher/{id}")
    public String saveUpdatePublisher(@PathVariable Long id, Publisher publisher, Model model , BindingResult result) {
        if (result.hasErrors()){
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers",publisherService.findAllPublishers());
        return "redirect:/publishers";
    }
}
