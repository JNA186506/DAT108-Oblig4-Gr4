package com.dat108.dat108oblig4gr4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dat108.dat108oblig4gr4.Deltagere;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.dat108.dat108oblig4gr4.Deltagere.deltagere;

@Controller
public class DeltagerController {

    @GetMapping("/paamelding")
    public String visPaamelding(Model model) {
        return "paamelding";
    }

    @PostMapping("/registrer")
    public String paamelding(Model model, String fornavn, String etternavn,
                             String kjonn, String mobil) {
        Deltager deltager = new Deltager(fornavn, etternavn, kjonn, mobil);

        model.addAttribute("deltager", deltager);
        return "paameldt";
    }

    @GetMapping("/deltagerView")
    public String alleDeltagere(Model model) {
        model.addAttribute("deltagere", deltagere);
        return "deltagerView";
    }

}
