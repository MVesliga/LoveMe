package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.repository.KorisnikRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/love-me")
public class KorisnikController {

    private KorisnikRepository korisnikRepository;

    public KorisnikController(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @GetMapping("/profil")
    public String getProfil(Model model, Principal principal) {
        //TODO makmnuti kasnije
        List<Korisnik> listaKorisnika = korisnikRepository.findAll();
        System.out.println(principal.getName());
        System.out.println("tu sam!");

        return "profil";
    }
}
