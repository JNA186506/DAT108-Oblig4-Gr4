package com.dat108.dat108oblig4gr4.controllers;

import com.dat108.dat108oblig4gr4.classes.Deltager;
import com.dat108.dat108oblig4gr4.classes.Passord;
import com.dat108.dat108oblig4gr4.services.DeltagerService;
import com.dat108.dat108oblig4gr4.services.LoginService;
import com.dat108.dat108oblig4gr4.services.PassordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/","/login"})
public class LoginController {

    private final PassordService passordService;
    private final DeltagerService deltagerService;
    private final LoginService loginService;

    @Autowired
    public LoginController(PassordService passordService,
                           DeltagerService deltagerService, LoginService loginService) {
        this.passordService = passordService;
        this.deltagerService = deltagerService;
        this.loginService = loginService;
    }

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String attemptLogin(@RequestParam String username,
                               @RequestParam String passord,
                               HttpServletRequest request,
                               RedirectAttributes ra) {

        Deltager deltager = deltagerService.finnDeltagerMedId(username);

        if (deltager == null) {
            ra.addFlashAttribute("feilNavn", "Brukernavn er feil eller finnes ikke");
            return "redirect:login";
        }

        Passord deltagerPassord = deltager.getPassord();

        boolean korrektPassord = passordService.erKorrektPassord(passord,
                deltagerPassord.getSalt(), deltagerPassord.getHash());

        if (!korrektPassord) {
            ra.addFlashAttribute("feilPassord", "Feil passord");
            return "redirect:login";
        }

        loginService.loggInnBruker(request, deltager);

        return "redirect:deltagerView";
    }
}
