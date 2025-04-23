package com.tamurbek;


import com.tamurbek.model.Users;
import com.tamurbek.services.ExternalApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/software-engineer")
public class SoftwareEngineerController {

    private final ExternalApiService externalApiService;
    private final SoftwareEngineerService softwareEngineerService;

    // 🔽 IKKALA SERVIS KONSTRUKTORDAN KELAYAPTI
    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService,
                                      ExternalApiService externalApiService) {
        this.softwareEngineerService = softwareEngineerService;
        this.externalApiService = externalApiService;
    }

    @GetMapping("/all")
    public List<SoftwareEngineer> getSoftWereEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getSoftWereEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping("/add")
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("/external-data/{id}")
    public ResponseEntity<Users> getExternalData(@PathVariable Long id) {
        Users data = externalApiService.getUserById(id);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/external-data/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> userList = externalApiService.getUserAll();
        return ResponseEntity.ok(userList);
    }
}

