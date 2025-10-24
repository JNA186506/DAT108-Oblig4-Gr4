package com.dat108.dat108oblig4gr4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeltagerService {
    @Autowired
    private Deltagere deltagere;
    //@Autowired
    //DeltagerRepo deltagerRepo;

    // public DeltagerService(DeltagerRepo deltagerRepo) {
        //this.deltagerRepo = deltagerRepo;
    //}

    public boolean passordDuplikat(Deltager deltager, String passord2) {
        return !deltager.getPassord().equals(passord2);
    }

    public boolean finnesMobil(Deltager deltager) {
        return deltagere.alleDeltagere().stream()
                .anyMatch(d -> d.getMobil().replaceAll("\\s+","")
                        .equals(deltager.getMobil()));
    }
}
