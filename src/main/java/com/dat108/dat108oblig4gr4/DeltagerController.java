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


import java.util.List;
import java.util.stream.Collectors;

import static com.dat108.dat108oblig4gr4.Deltagere.deltagere;

@Controller
public class DeltagerController {

    @Autowired private DeltagerService deltagerService;

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
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errors = validator(deltager, bindingResult);
            model.addAttribute("errors", errors);
            return "paamelding";
        }

        ra.addFlashAttribute("deltager", deltager);
        return "redirect:paameldt";
    }

    @GetMapping("/paameldt")
    public String paameldt() {
        return "paameldt";
    }

    @GetMapping("/deltagerView")
    public String alleDeltagere(Model model) {
        model.addAttribute("deltagere", deltagere);

        return "deltagerView";
    }

    /* Dette er i utgangspunktet business-logikk og bør flyttes ut av
    controlleren. Er ikke helt sikker på hva som er den beste måten å gjøre det på.
    En Service
     */
    private List<String> validator(Deltager deltager,
                                   BindingResult bindingResult) {

        boolean finnesMobil = deltagere.stream()
                .anyMatch(d -> d.getMobil().equals(deltager.getMobil()));

        List<String> errorMessages = null;
        List<ObjectError> errors = bindingResult.getAllErrors();

        errorMessages = errors.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        if (finnesMobil) {
            errorMessages.add("Mobilnummer eksisterer allerede");
        }

        return errorMessages;
    }
}
