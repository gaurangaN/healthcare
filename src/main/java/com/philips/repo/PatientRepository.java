package com.philips.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	

}
