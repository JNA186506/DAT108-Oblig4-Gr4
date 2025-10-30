package com.dat108.dat108oblig4gr4.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void loggUtBruker(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

    public void loggInnBruker(HttpServletRequest request,
                              String username, String password) {
        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
    }
}
