package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.repository.LjubimacRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LjubimacController {

    private LjubimacRepository ljubimacRepository;

    public LjubimacController(LjubimacRepository ljubimacRepository) {
        this.ljubimacRepository = ljubimacRepository;
    }

    @GetMapping(value = "/moji-ljubimci")
    public String getLjubimci(Model model) {
        List<Ljubimac> listaLjubimaca = ljubimacRepository.findAll();

        model.addAttribute("ljubimci", listaLjubimaca);
        return "moji_ljubimci";
    }

    @GetMapping("/ljubimac")
    public String getLjubimac(@RequestParam(value = "id")Integer id, Model model){
        Ljubimac ljubimac = ljubimacRepository.findById(id).get();

        model.addAttribute("ljubimac", ljubimac);
        return "ljubimac";
    }

    @GetMapping("/novi-ljubimac")
    public String novi_ljubimac(){
        return "novi_ljubimac";
    }

    @GetMapping("/uredi-ljubimca")
    public String getLjubimacEdit(@RequestParam(value = "id")Integer id, Model model){
        Ljubimac ljubimac = ljubimacRepository.findById(id).get();

        model.addAttribute("ljubimac", ljubimac);
        return "uredi_ljubimca";
    }
}
