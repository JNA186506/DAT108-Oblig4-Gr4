package com.dat108.dat108oblig4gr4.classes;

import jakarta.persistence.Embeddable;

@Embeddable
public class Passord {
    private String hash;
    private String salt;

    public Passord() { }

    public Passord(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }
}
