package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.form.LjubimacForm;
import hr.tvz.loveme.facade.LjubimacFacade;
import hr.tvz.loveme.repository.LjubimacRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.validation.Valid;

@Controller
public class LjubimacController {

    private LjubimacFacade ljubimacFacade;

    public LjubimacController(LjubimacFacade ljubimacFacade) {
        this.ljubimacFacade = ljubimacFacade;
    }

    @GetMapping(value = "/moji-ljubimci")
    public String getLjubimci(Model model) {
        List<Ljubimac> listaLjubimaca = ljubimacFacade.getLjubimacRepository().findAll();

        model.addAttribute("ljubimci", listaLjubimaca);
        return "moji_ljubimci";
    }

    @GetMapping("/ljubimac")
    public String getLjubimac(@RequestParam(value = "id")Integer id, Model model){
        Ljubimac ljubimac = ljubimacFacade.getLjubimacRepository().findById(id).get();

        model.addAttribute("ljubimac", ljubimac);
        return "ljubimac";
    }

    @GetMapping("/novi-ljubimac")
    public String getLjubimacForm(Model model) {
        if (!model.containsAttribute("ljubimacForm")) {
            model.addAttribute("ljubimacForm", new LjubimacForm());
        }

        return "novi_ljubimac";
    }

    @PostMapping("/novi-ljubimac")
    public String addLjubimac(@ModelAttribute @Valid LjubimacForm ljubimacForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ljubimacForm", bindingResult);
            redirectAttributes.addFlashAttribute("ljubimacForm", ljubimacForm);

            return "redirect:/moji_ljubimci";
        }

        ljubimacFacade.create(ljubimacForm);

        return "redirect:/moji_ljubimci";
    }

    @GetMapping("/uredi-ljubimca")
    public String getLjubimacEdit(@RequestParam(value = "id")Integer id, Model model){
        Ljubimac ljubimac = ljubimacFacade.getLjubimacRepository().findById(id).get();

        model.addAttribute("ljubimac", ljubimac);
        return "uredi_ljubimca";
    }
}
