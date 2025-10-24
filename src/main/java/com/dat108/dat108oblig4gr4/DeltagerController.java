package com.dat108.dat108oblig4gr4;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DeltagerController {

    @Autowired
    private DeltagerService deltagerService;
    @Autowired
    private Deltagere deltagere;

    public DeltagerController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }

    @GetMapping("/paamelding")
    public String visPaamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paamelding";
    }

    @PostMapping("/registrer")
    public String paamelding(RedirectAttributes ra, Model model,
                             @Valid @ModelAttribute("deltager") Deltager deltager,
                             BindingResult bindingResult,
                             String passord2) {

        boolean finnesMobil = deltagerService.finnesMobil(deltager);
        boolean duplisertPassord = deltagerService.passordDuplikat(deltager, passord2);

        if (finnesMobil) {
            model.addAttribute("mobilFinnes", "Mobilnummer finnes allerede");
        }

        if (duplisertPassord) {
            model.addAttribute("passordErLikt", "Passord er ulike");
        }

        List<String> errorMessages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errorMessages = errors.stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.toList());
            model.addAttribute("errors", errorMessages);
        }

        if (!errorMessages.isEmpty() || finnesMobil || duplisertPassord) {
            return "paamelding";
        }

        deltagere.add(deltager);

        ra.addFlashAttribute("deltager", deltager);
        return "redirect:paameldt";
    }

    @GetMapping("/paameldt")
    public String paameldt() {
        return "paameldt";
    }

    @GetMapping("/deltagerView")
    public String alleDeltagere(Model model) {
        model.addAttribute("deltagere", deltagere.alleDeltagere());

        return "deltagerView";
    }


}
