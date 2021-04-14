package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class KorisnikController {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public KorisnikController(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

/*    @GetMapping("/profil")
    public String getProfil(Model model) {
        //TODO makmnuti kasnije
        List<Korisnik> listaKorisnika = korisnikRepository.findAll();
        Korisnik korisnik = korisnikRepository.findById(1).get();
        model.addAttribute("korisnik", korisnik);
        System.out.println("tu sam! "+ korisnik);

        return "profil";
    }*/

    @RequestMapping(value = "/profil", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {

        return principal.getName();
    }

}
