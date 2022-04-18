package com.patient1.patient1.repositories;

import com.patient1.patient1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
