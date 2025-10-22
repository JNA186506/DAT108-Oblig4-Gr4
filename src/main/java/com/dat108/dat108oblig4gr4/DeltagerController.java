package com.dat108.dat108oblig4gr4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dat108.dat108oblig4gr4.Deltagere;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.dat108.dat108oblig4gr4.Deltagere.deltagere;

@Controller
public class DeltagerController {

    @GetMapping("/paamelding")
    public String visPaamelding(Model model) {
        return "paamelding";
    }

    @PostMapping("/registrer")
    public String paamelding(Model model, RedirectAttributes ra, String fornavn, String etternavn,
                             String kjonn, String mobil) {
        Deltager deltager = new Deltager(fornavn, etternavn, kjonn, mobil);

        ra.addFlashAttribute("deltager", deltager);
        return "redirect:paameldt";
    }

    @GetMapping("/paameldt")
    public String paameldt(Model model, RedirectAttributes ra) {
        return "paameldt";
    }

    @GetMapping("/deltagerView")
    public String alleDeltagere(Model model) {
        model.addAttribute("deltagere", deltagere);

        return "deltagerView";
    }

}
