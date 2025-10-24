package com.dat108.dat108oblig4gr4;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepo extends JpaRepository<Deltager, Integer> {
    boolean finnesMobil(String mobil);
}
