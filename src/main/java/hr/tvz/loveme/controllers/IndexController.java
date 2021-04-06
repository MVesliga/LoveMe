package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.form.KorisnikForm;
import hr.tvz.loveme.domain.Ljubimac;

import java.util.ArrayList;
import java.util.List;

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

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/registracija")
    public String getKorisnikRegistracijaForm(final Model model) {
        if (!model.containsAttribute("korisnikForm")) {
            KorisnikForm korisnikForm = new KorisnikForm();
            model.addAttribute("korisnikForm", korisnikForm);
        }
        return "registracija";
    }

    @PostMapping("/registracija")
    public String registerKokrisnik(@ModelAttribute @Validated KorisnikForm korisnikForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.korisnikForm", bindingResult);
            redirectAttributes.addFlashAttribute("korisnikForm", korisnikForm);
            return "redirect:/registracija";
        }

        return "index";
    }

    @GetMapping("/prijava")
    public String login(){
        return "login";
    }

    @GetMapping("/landing")
    public String landing(){
        return "landing";
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
