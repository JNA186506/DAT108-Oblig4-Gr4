package com.dat108.dat108oblig4gr4.controllers;

import com.dat108.dat108oblig4gr4.services.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("logout")
public class LogoutController {

    private final LoginService loginService;

    @Autowired
    public LogoutController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String loggUt(RedirectAttributes ra, HttpSession session) {
        loginService.loggUtBruker(session);
        ra.addFlashAttribute("loggetUt", "Du har blitt logget ut");

        return "redirect:/login";
    }
}
