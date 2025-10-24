package com.dat108.dat108oblig4gr4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.dat108.dat108oblig4gr4.DeltagerController;
import org.springframework.stereotype.Service;

@Service
public class Deltagere {
    private List<Deltager> deltagere = new ArrayList<>();

    public Deltagere() {
        deltagere.add(new Deltager("Anne", "Panne", "Kvinne", "234 56 789"));
        deltagere.add(new Deltager("Xx-x", "Xxx", "Kvinne", "123 21 378"));
        deltagere.add(new Deltager("Arne", "Arnesen", "Mann", "901 23 456"));
        deltagere.add(new Deltager("Per", "Viskelær", "Mann", "345 34 534"));
        deltagere.add(new Deltager("Lars-Petter", "Helland", "Mann", "123 45 679"));
    }

    public void add(Deltager deltager) {
        deltagere.add(deltager);
    }

    public Deltager remove(Deltager deltager) {
        if (deltagere.remove(deltager)) {
            return deltager;
        }

        return null;
    }

    public List<Deltager> alleDeltagere() {
        return deltagere.stream().sorted(Comparator.comparing(Deltager::getFornavn)
                .thenComparing(Deltager::getEtternavn)).toList();
    }
}
