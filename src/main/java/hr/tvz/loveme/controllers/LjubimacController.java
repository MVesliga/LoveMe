package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Ljubimac;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LjubimacController {

    @GetMapping(value = "/moji-ljubimci")
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

    @GetMapping("/novi-ljubimac")
    public String novi_ljubimac(){
        return "novi_ljubimac";
    }
}
