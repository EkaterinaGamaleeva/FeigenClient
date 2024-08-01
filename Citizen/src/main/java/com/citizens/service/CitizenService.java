package com.citizens.service;

import com.citizens.model.Citizen;
import com.citizens.repositiry.CitizenRepository;
import com.citizens.response.CitizenNotFoundExcention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CitizenService {
    private final CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> getCitizen() {
        return citizenRepository.findAll();
    }

    @Transactional
    public void save(Citizen citizen) {
        citizenRepository.save(citizen);
    }
    @Transactional
    public void delete(Long id) {
        citizenRepository.deleteById(id);
    }
    @Transactional
    public void update(Long id, Citizen updateCitizen) {
        updateCitizen.setId(id);
        citizenRepository.save(updateCitizen);

    }
    public List<Citizen> getCitizenCity(String c) {
        return citizenRepository.findByCity(c).orElseThrow(CitizenNotFoundExcention::new);
    }
}
