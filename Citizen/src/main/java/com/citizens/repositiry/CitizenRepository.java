package com.citizens.repositiry;

import com.citizens.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Long> {
    Optional<List<Citizen>> findByCity(String city);
}
