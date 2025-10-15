package com.dat108.dat108oblig4gr4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerController {

    @GetMapping
    public String alleDeltagere(Model model) {

        return "deltagerView";
    }

}
