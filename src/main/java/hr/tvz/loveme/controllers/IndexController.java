package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.form.KorisnikForm;
import hr.tvz.loveme.domain.Ljubimac;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.loveme.domain.form.LoginForm;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/registracija")
    public String getKorisnikRegistracijaForm(Model model) {
        if (!model.containsAttribute("korisnikForm")) {
            model.addAttribute("korisnikForm", new KorisnikForm());
        }

        return "registracija";
    }

    @PostMapping("/registracija")
    public String registerKokrisnik(@ModelAttribute @Valid KorisnikForm korisnikForm,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registracija";
        }

        return "redirect:/";
    }

    @GetMapping("/prijava")
    public String getLoginForm(Model model){
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
        }
        return "login";
    }

    @PostMapping("/prijava")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "redirect:/love-me";
    }

    @GetMapping("/love-me")
    public String getLandingPage() {
        return "landing";
    }

    @GetMapping("/logout")
    public String logout() {

        return "redirect:/";
    }

    @RequestMapping(value = "/moji_ljubimci", method = RequestMethod.GET)
    public String read(Model model) {
        Ljubimac test1 = new Ljubimac(1, "pas", "pas", 1, null, null, null, "ne", null);
        Ljubimac test2 = new Ljubimac(2, "macka", "macka", 3, null, null, null, "ne", null);
        Ljubimac test3 = new Ljubimac(3, "korni", "kornjaca", 112, null, null, null, "da", null);

        List<Ljubimac> test_ljubimci = new ArrayList<Ljubimac>();
        test_ljubimci.add(test1);
        test_ljubimci.add(test2);
        test_ljubimci.add(test3);

        model.addAttribute("test_ljubimci", test_ljubimci);

        return "moji_ljubimci";
    }

    /* @GetMapping("/moji_ljubimci")
    public String moji_ljubimci(){
        return "moji_ljubimci";
    } */

    @GetMapping("/ljubimac")
    public String ljubimac(){
        return "ljubimac";
    }

    @GetMapping("/novi_ljubimac")
    public String novi_ljubimac(){
        return "novi_ljubimac";
    }
}
