package am.itspace.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap map, @RequestParam(value = "message", required = false) String message) {
        return "index";
    }

    @GetMapping(value = "/")
    public String main() {
        return "redirect:/home";
    }

}
