package am.itspace.springdemo.controller;

import am.itspace.springdemo.model.Author;
import am.itspace.springdemo.repository.AuthorRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class AuthorViewController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/addAuthorView")
    public String addAuthor(ModelMap map) {
        map.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author, BindingResult result, @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        String picName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File file = new File("D:\\mvc\\" + picName);
        multipartFile.transferTo(file);
        author.setPicUrl(picName);
        authorRepository.save(author);
        return "redirect:/home";
    }

    @GetMapping("/viewAllAuthors")
    public String authorsPage(ModelMap map) {
        map.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream("D:\\mvc\\" + fileName);
        response.setContentType(MediaType.ALL_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
