package com.dat108.dat108oblig4gr4.controllers;

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
@RequestMapping("login")
public class LoginController {

    @Autowired
    private PassordService passordService;

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String attemptLogin(@RequestParam String username,
                               @RequestParam String passord,
                               HttpServletRequest request,
                               RedirectAttributes ra) {

        return "redirect:deltagerView";
    }
}
