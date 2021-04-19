package hr.tvz.loveme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/love-me")
public class ForumController {
    /**
     * Metoda koja se poziva prilikom dohvacanja foruma ulogiranog korisnika.
     * @param model objekt pomocu kojeg se korisnicki objekt salje u html template
     * @return stranica sa prikazom foruma korisnika
     */
    @GetMapping("/forum")
    public String getForum(Model model) {
        return "forum";
    }
}
