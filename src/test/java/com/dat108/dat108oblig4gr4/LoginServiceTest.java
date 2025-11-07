package com.dat108.dat108oblig4gr4;

import com.dat108.dat108oblig4gr4.classes.Deltager;
import com.dat108.dat108oblig4gr4.classes.Passord;
import com.dat108.dat108oblig4gr4.services.LoginService;
import com.dat108.dat108oblig4gr4.services.PassordService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    private PassordService passordService;

    private LoginService loginService = new LoginService();

    private MockHttpServletRequest request;

    private Deltager deltager;

    @BeforeAll
    public void setUpDeltager() {
        passordService = new PassordService();
        deltager = new Deltager("Anne", "Panne", "Kvinne","23456789");

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt("Johannes123!", salt);
        Passord hashetPassord = new Passord(hash, salt);

        deltager.setPassord(hashetPassord);
    }

    @BeforeEach
    public void setUpRequest() {
        request = new MockHttpServletRequest();
    }

    @Test
    public void ikkeInnloggetFraStart() {
        assertFalse(loginService.erBrukerInnlogget(request));
    }

    @Test
    public void innloggingOgUtloggingTest() {
        loginService.loggInnBruker(request, deltager);
        assertTrue(loginService.erBrukerInnlogget(request));

        loginService.loggUtBruker(request);
        assertFalse(loginService.erBrukerInnlogget(request));
    }

}
