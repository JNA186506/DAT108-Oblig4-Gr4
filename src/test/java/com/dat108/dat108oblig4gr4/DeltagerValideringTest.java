package com.dat108.dat108oblig4gr4;

import com.dat108.dat108oblig4gr4.classes.Deltager;
import com.dat108.dat108oblig4gr4.classes.Passord;
import com.dat108.dat108oblig4gr4.services.DeltagerService;
import com.dat108.dat108oblig4gr4.services.PassordService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DeltagerValideringTest {

    private Validator validator;

    private Deltager deltager;

    @Autowired
    private DeltagerService deltagerService;

    @Autowired
    private PassordService passordService;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        deltager = new Deltager();
        deltager.setFornavn("Johannes");
        deltager.setEtternavn("Antonsen");
        deltager.setMobil("46860501");
        deltager.setKjonn("Mann");

        String passord = "Johannes123!";
        String salt = passordService.genererTilfeldigSalt();
        String hashedPassord = passordService.hashMedSalt(passord, salt);
        Passord pass = new Passord(hashedPassord, salt);
        deltager.setPassord(pass);
    }

    @Test
    void testDeltagerErGyldig() {
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }

    @Test
    void harNavn() {
        deltager.setFornavn(null);
        sjekkAtUgyldig("Navn er påkrevd");
    }

    @Test
    void harGyldigEtternavn() {
        deltager.setEtternavn("J0hannes");
        sjekkAtUgyldig("Navn kan kun inneholde bokstaver, bindestrek og mellomrom");
    }

    @Test
    void harGyldigFornavn() {
        deltager.setFornavn("J0hannes");
        sjekkAtUgyldig("Navn kan kun inneholde bokstaver, bindestrek og mellomrom");
    }

    @Test
    void finnesMobil() {
        deltager.setMobil("23456789");
        assertTrue(deltagerService.finnesMobil(deltager));
    }

    @Test
    void riktigPassord() {
        String forsok1 = "J0hannes123!";
        Passord riktigPass = deltager.getPassord();
        assertFalse(passordService.erKorrektPassord(forsok1, riktigPass.getSalt(), riktigPass.getHash()));

        String forsok2 = "Johannes123!";
        assertTrue(passordService.erKorrektPassord(forsok2, riktigPass.getSalt(), riktigPass.getHash()));
    }

    private void sjekkAtUgyldig(String feilmelding) {
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);
        assertFalse(violations.isEmpty());
        assertThat(violations).hasSize(1);

        String violationMessage = violations.iterator().next().getMessage();
        assertEquals(feilmelding, violationMessage);
    }
}
