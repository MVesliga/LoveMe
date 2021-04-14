package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.KorisnikUloga;
import hr.tvz.loveme.domain.form.KorisnikForm;

import hr.tvz.loveme.domain.form.LoginForm;
import hr.tvz.loveme.facade.KorisnikFacade;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

    private KorisnikFacade korisnikFacade;

    public IndexController(KorisnikFacade korisnikFacade) {
        this.korisnikFacade = korisnikFacade;
    }

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
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        Korisnik existing = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(korisnikForm.getKorisnickoIme());
        if (existing != null) {
            bindingResult.rejectValue("korisnickoIme", null, "Postoji korisnik sa unesenim korisničkim imenom!");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.korisnikForm", bindingResult);
            redirectAttributes.addFlashAttribute("korisnikForm", korisnikForm);

            return "redirect:/registracija";
        }

        KorisnikUloga korisnikUloga = new KorisnikUloga(korisnikForm.getKorisnickoIme(), "ROLE_USER");
        korisnikFacade.create(korisnikForm);
        korisnikFacade.getKorisnikUlogaRepository().save(korisnikUloga);

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
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", bindingResult);
            redirectAttributes.addFlashAttribute("loginForm", loginForm);

            return "redirect:/prijava";
        }

        return "redirect:/love-me";
    }

    @GetMapping("/love-me")
    public String getLandingPage() {
        return "landing";
    }

    @PostMapping("/logout")
    public String logout() {

        SecurityContextHolder.getContext().getAuthentication();

        System.out.println("tu sam");
        return "redirect:/";
    }
}
