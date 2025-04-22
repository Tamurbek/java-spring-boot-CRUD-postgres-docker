package com.tamurbek;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/softwere-engineer")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
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

}
