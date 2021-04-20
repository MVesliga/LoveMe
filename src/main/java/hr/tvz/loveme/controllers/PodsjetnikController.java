package hr.tvz.loveme.controllers;

import hr.tvz.loveme.converter.PodsjetnikConverter;
import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.Podsjetnik;
import hr.tvz.loveme.domain.form.PodsjetnikForm;
import hr.tvz.loveme.domain.form.UpdatePodsjetnikForm;
import hr.tvz.loveme.facade.PodsjetnikFacade;
import hr.tvz.loveme.facade.KorisnikFacade;
import hr.tvz.loveme.facade.LjubimacFacade;

import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/love-me")
public class PodsjetnikController {

    private PodsjetnikFacade podsjetnikFacade;
    private KorisnikFacade korisnikFacade;
    private LjubimacFacade ljubimacFacade;
    private PodsjetnikConverter podsjetnikConverter;

    public PodsjetnikController(KorisnikFacade korisnikFacade, PodsjetnikFacade podsjetnikFacade, LjubimacFacade ljubimacFacade, PodsjetnikConverter podsjetnikConverter) {
        this.korisnikFacade = korisnikFacade;
        this.podsjetnikFacade = podsjetnikFacade;
        this.ljubimacFacade = ljubimacFacade;
        this.podsjetnikConverter = podsjetnikConverter;
    }

    @GetMapping(value = "/podsjetnici")
    public String getPodsjetnici(Model model, Principal principal) {
        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        List<Podsjetnik> listaPodsjetnika = podsjetnikFacade.getPodsjetnikRepository().findByKorisnik(korisnik);
        
        model.addAttribute("podsjetnici", listaPodsjetnika);
        return "podsjetnici";
    }

    @GetMapping(value = "/novi-podsjetnik")
    public String getPodsjetnikForm(Model model, Principal principal) {
        if (!model.containsAttribute("podsjetnkForm")) {
            model.addAttribute("podsjetnikForm", new PodsjetnikForm());
        }

        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        List<Ljubimac> listaLjubimaca = ljubimacFacade.getLjubimacRepository().findByKorisnik(korisnik);
        
        model.addAttribute("ljubimci", listaLjubimaca);
        return "novi_podsjetnik";
    }

    @PostMapping("/novi-podsjetnik")
    public String addPodsjetnik(@ModelAttribute @Valid PodsjetnikForm podsjetnikForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.podsjetnikForm", bindingResult);
            redirectAttributes.addFlashAttribute("podsjetnikForm", podsjetnikForm);

            return "redirect:/love-me/novi-podsjetnik";
        }

        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        podsjetnikForm.setKorisnik(korisnik);

        podsjetnikFacade.create(podsjetnikForm);

        redirectAttributes.addFlashAttribute("createPodsjetnikSuccess", true);
        return "redirect:/love-me/podsjetnici";
    }

    @GetMapping("/uredi-podsjetnik")
    public String getPodsjetnikEdit(@RequestParam(value = "id")Integer id, Model model, Principal principal){

        if (!model.containsAttribute("updatePodsjetnikForm")) {
            Podsjetnik podsjetnik = podsjetnikFacade.getPodsjetnikRepository().findById(id).get();
            UpdatePodsjetnikForm updatePodsjetnikForm = podsjetnikConverter.convertToForm(podsjetnik);
            model.addAttribute("updatePodsjetnikForm", updatePodsjetnikForm);
        }

        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        List<Ljubimac> listaLjubimaca = ljubimacFacade.getLjubimacRepository().findByKorisnik(korisnik);

        model.addAttribute("updatePodsjetnikForm", model.getAttribute("updatePodsjetnikForm"));
        model.addAttribute("ljubimci", listaLjubimaca);

        return "uredi_podsjetnik";
    }

    @PostMapping("/uredi-podsjetnik")
    public String editPodsjetnik(@ModelAttribute @Valid UpdatePodsjetnikForm updatePodsjetnikForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updatePodsjetnikForm", bindingResult);
            redirectAttributes.addFlashAttribute("updatePodsjetnikForm", updatePodsjetnikForm);

            return "redirect:/love-me/uredi-podsjetnik";
        }
        Podsjetnik podsjetnik = podsjetnikFacade.getPodsjetnikRepository().findById(updatePodsjetnikForm.getId()).get();

        Podsjetnik editedPodsjetnik = podsjetnikConverter.convertUpdatePodsjetnikForm(updatePodsjetnikForm, podsjetnik);
        podsjetnikFacade.getPodsjetnikRepository().save(editedPodsjetnik);

        redirectAttributes.addFlashAttribute("updatePodsjetnikSuccess", true);
        return "redirect:/love-me/podsjetnici";
    }

    @GetMapping("/delete/podsjetnik")
    public String deletePodsjetnik(@RequestParam("podsjetnikId") Integer podsjetnikId,
                                 RedirectAttributes redirectAttributes){
        podsjetnikFacade.getPodsjetnikRepository().deleteById(podsjetnikId);

        redirectAttributes.addFlashAttribute("deletePodsjetnikSuccess", true);
        return "redirect:/love-me/podsjetnici";
    }
}
