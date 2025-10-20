package com.dat108.dat108oblig4gr4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dat108.dat108oblig4gr4.Deltagere;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.dat108.dat108oblig4gr4.Deltagere.deltagere;

@Controller
public class DeltagerController {

    @GetMapping("/deltagerView")
    public String alleDeltagere(Model model) {
        model.addAttribute("deltagere", deltagere);
        return "deltagerView";
    }

    @PostMapping("/paamelding.html")
    public String paamelding(Model model, String fornavn, String etternavn,
                             String kjonn, String mobilnummer) {
        Deltager deltager = new Deltager(fornavn, etternavn, kjonn, mobilnummer);

        deltagere.add(deltager);

        model.addAttribute("deltager", deltager);
        return "paameldt";
    }
}
