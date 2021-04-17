package hr.tvz.loveme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/love-me")
public class ForumController {
    @GetMapping("/forum")
    public String getForum(Model model) {
        return "forum";
    }
}
