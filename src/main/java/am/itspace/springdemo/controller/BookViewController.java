package am.itspace.springdemo.controller;

import am.itspace.springdemo.model.Author;
import am.itspace.springdemo.model.Book;
import am.itspace.springdemo.repository.AuthorRepository;
import am.itspace.springdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookViewController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/addBookView")
    public String addBook(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("authors", authorRepository.findAll());
        return "addBook";
    }

    @PostMapping("/saveBook")
    public String saveBook( @ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/home";
    }

    @GetMapping("/viewAllBooks")
    public String getBooks(ModelMap map){
        map.addAttribute("books",bookRepository.findAll());
        return "books";
    }

}