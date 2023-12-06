package com.course.librarymanagement;

import com.course.librarymanagement.entity.Author;
import com.course.librarymanagement.entity.Book;
import com.course.librarymanagement.entity.Category;
import com.course.librarymanagement.entity.Publisher;
import com.course.librarymanagement.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementApplication.class, args);}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("author", "Test description one");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.AddAuthor(author1);
			book1.AddCategory(category1);
			book1.AddPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC1", "Book", "My second book");
			Author author2 = new Author("auth", "Test description two");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second Publisher");
			book2.AddAuthor(author2);
			book2.AddCategory(category2);
			book2.AddPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC21", "name", "My third book");
			Author author3 = new Author("Taut", "Test description three");
			Category category3 = new Category("Fiction books");
			Publisher publisher3 = new Publisher("Third Publisher");
			book3.AddAuthor(author3);
			book3.AddCategory(category3);
			book3.AddPublisher(publisher3);
			bookService.createBook(book3);
		};
	}
}
