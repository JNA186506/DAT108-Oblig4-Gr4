package com.dat108.dat108oblig4gr4.controllers;

import com.dat108.dat108oblig4gr4.classes.Deltager;
import com.dat108.dat108oblig4gr4.services.DeltagerService;
import com.dat108.dat108oblig4gr4.services.LoginService;
import com.dat108.dat108oblig4gr4.services.PassordService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DeltagerController {

    private final DeltagerService deltagerService;
    private final LoginService loginService;

    @Autowired
    public DeltagerController(DeltagerService deltagerService,
                              LoginService loginService) {
        this.deltagerService = deltagerService;
        this.loginService = loginService;
    }

    @GetMapping("/paamelding")
    public String visPaamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paamelding";
    }

    @PostMapping("/registrer")
    public String paamelding(RedirectAttributes ra,
                             @RequestParam String passordKlarTekst,
                             @Valid @ModelAttribute("deltager") Deltager deltager,
                             BindingResult bindingResult) {

        boolean finnesMobil = deltagerService.finnesMobil(deltager);

        deltagerService.finnesMobil(deltager);

        if (finnesMobil) {
            ra.addFlashAttribute("mobilFinnes", "Mobilnummer finnes allerede");
        }

        List<String> errorMessages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errorMessages = errors.stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.toList());
            ra.addFlashAttribute("errors", errorMessages);
        }

        if (!errorMessages.isEmpty() || finnesMobil) {
            return "redirect:paamelding";
        }

        deltagerService.generatePassord(deltager, passordKlarTekst);
        deltagerService.leggTilDeltager(deltager);

        ra.addFlashAttribute("deltager", deltager);
        return "redirect:paameldt";
    }

    @GetMapping("/paameldt")
    public String paameldt() {
        return "paameldt";
    }

    @GetMapping("/deltagerView")
    public String alleDeltagere(Model model, HttpSession session, RedirectAttributes ra) {

        if (!loginService.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("ikkeLoggetInn", "Du er ikke logget inn");
            return "redirect:login";
        }
        model.addAttribute("deltagere", deltagerService.finnAlleDeltagere());

        return "deltagerView";
    }
}
