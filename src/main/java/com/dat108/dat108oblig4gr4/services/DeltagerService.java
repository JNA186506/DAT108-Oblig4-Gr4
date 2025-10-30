package com.dat108.dat108oblig4gr4.services;

import com.dat108.dat108oblig4gr4.classes.Deltager;
import com.dat108.dat108oblig4gr4.interfaces.DeltagerRepo;
import com.dat108.dat108oblig4gr4.classes.Passord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeltagerService {

    @Autowired
    private DeltagerRepo deltagerRepo;

    @Autowired
    private PassordService passordService;

    public DeltagerService(DeltagerRepo deltagerRepo, PassordService passordService) {
        this.deltagerRepo = deltagerRepo;
        this.passordService = passordService;
    }

    public List<Deltager> finnAlleDeltagere() { return deltagerRepo.findAll(); }

    public void leggTilDeltager(Deltager deltager) {
        deltagerRepo.save(deltager);
    }

    public boolean finnesMobil(Deltager deltager) {
        return deltagerRepo.existsById(deltager.getMobil());
    }

    public void generatePassord(Deltager deltager, String passordKlarTekst) {

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(passordKlarTekst, salt);

        Passord hashetPassord = new Passord(hash, salt);
        deltager.setPassord(hashetPassord);
    }
}
