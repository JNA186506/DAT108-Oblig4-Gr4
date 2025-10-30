package com.dat108.dat108oblig4gr4.interfaces;

import com.dat108.dat108oblig4gr4.classes.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepo extends JpaRepository<Deltager, String> {
}
