package com.dat108.dat108oblig4gr4.services;

import com.dat108.dat108oblig4gr4.classes.Deltager;
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
                              Deltager deltager) {
        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setAttribute("deltager", deltager);
        session.setMaxInactiveInterval(120);
    }

    public boolean erBrukerInnlogget(HttpSession session) {
        return session == null || session.getAttribute("deltager") == null;
    }
}
