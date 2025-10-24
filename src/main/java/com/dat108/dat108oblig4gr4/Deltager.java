package com.dat108.dat108oblig4gr4;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Deltager {
    @Pattern(regexp = "^\\d{8}$", message = "mobilnummer må være 8 siffer")
    @NotNull(message="mobilnummer er påkrevd")
    private String mobil;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!?]).{8,}$",
    message = "Passord kan kun innehold små og store bokstaver, tall, må minst inneholde et spesialtegn og minst 8 tegn")
    private String passord;

    @Size(min = 2, message="Navn må inneholde minst to tegn")
    @Pattern(regexp = "[a-zæøåA-ZÆØÅ]+([ -][a-zæøåA-ZÆØÅ]+)*")
    @NotNull(message = "Navn er påkrevd")
    private String fornavn;

    @Size(min = 2, message="Navn må inneholde minst to tegn")
    @Pattern(regexp = "[a-zæøåA-ZÆØÅ]+([ -][a-zæøåA-ZÆØÅ]+)*",
    message = "navn kan kun inneholde bokstaver, bindestrek og mellomrom")
    private String etternavn;

    @Pattern(regexp = "(?i)^(mann|kvinne)$", flags  = Pattern.Flag.CASE_INSENSITIVE)
    private String kjonn;

    public Deltager() {}

    //Slett til neste oppgave
    public Deltager(String fornavn, String etternavn, String kjonn, String mobil) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.mobil = mobil;
    }

    public Deltager(String fornavn, String etternavn, String kjonn, String mobil, String passord) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.mobil = mobil;
        this.passord = passord;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
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

    public int hashMobil(String mobil) {
        return mobil.hashCode();
    }
}