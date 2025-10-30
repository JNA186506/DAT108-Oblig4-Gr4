package com.dat108.dat108oblig4gr4.classes;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Table;

@Entity
@Table(schema = "deltager_schema", name = "deltager")
public class Deltager {

    @Id
    @Pattern(regexp = "^\\d{8}$", message = "mobilnummer må være 8 siffer")
    @NotNull(message="mobilnummer er påkrevd")
    private String mobil;

    @Embedded
    private Passord passord;

    /* @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!?]).{8,}$",
    message = "Passord kan kun innehold små og store bokstaver, tall, må minst inneholde et spesialtegn og minst 8 tegn")
    private String passord; */

    @Size(min = 2, message="Navn må inneholde minst to tegn")
    @Pattern(regexp = "[A-ZÆØÅ]{1}[a-zæøå]+([ -][A-ZÆØÅ]{1}[a-zæøå]+)*",
    message = "Navn kan kun inneholde bokstaver, bindestrek og mellomrom")
    @NotNull(message = "Navn er påkrevd")
    private String fornavn;

    @Size(min = 2, message="Navn må inneholde minst to tegn")
    @Pattern(regexp = "[A-ZÆØÅ]{1}[a-zæøå]+([ -][A-ZÆØÅ]{1}[a-zæøå]+)*",
    message = "Navn kan kun inneholde bokstaver, bindestrek og mellomrom")
    @NotNull(message = "Navn er påkrevd")
    private String etternavn;

    @Pattern(regexp = "(?i)^(mann|kvinne)$", flags  = Pattern.Flag.CASE_INSENSITIVE)
    private String kjonn;

    public Deltager() {}

    public Deltager(String fornavn, String etternavn, String kjonn, String mobil) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.mobil = mobil;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public Passord getPassord() {
        return passord;
    }

    public void setPassord(Passord passord) {
        this.passord = passord;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

}