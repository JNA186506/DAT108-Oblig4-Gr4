package com.dat108.dat108oblig4gr4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class DeltagerValideringTest {

    private Validator validator;

    private Deltager deltager;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        deltager = new Deltager();
        deltager.setFornavn("Johannes");
        deltager.setEtternavn("Antonsen");
        deltager.setMobil("46860501");
        deltager.setKjonn("Mann");
        deltager.setPassord("Johannes123!");
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

    }

    private void sjekkAtUgyldig(String feilmelding) {
        Set<ConstraintViolation<Deltager>> violations = validator.validate(deltager);
        assertFalse(violations.isEmpty());
        assertThat(violations).hasSize(1);

        String violationMessage = violations.iterator().next().getMessage();
        assertEquals(feilmelding, violationMessage);
    }
}
