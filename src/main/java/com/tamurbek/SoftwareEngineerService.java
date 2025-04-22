package com.tamurbek;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService {

    public SoftwareEngineerRepository getSoftwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository getSoftwareEngineerRepository) {
        this.getSoftwareEngineerRepository = getSoftwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return getSoftwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        getSoftwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return getSoftwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("SoftwareEngineer with id " + id + " not found!"));
    }
}
