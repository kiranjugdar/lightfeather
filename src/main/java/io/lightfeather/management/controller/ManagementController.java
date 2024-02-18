package io.lightfeather.management.controller;

import io.lightfeather.management.model.UserDetails;
import io.lightfeather.management.service.ManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @GetMapping("/supervisors")
    public List<String> getSupervisors() {
        return managementService.getSupervisors();
    }

    @PostMapping("/submit")
    public void submit(@Valid @RequestBody UserDetails userDetails) {
        logger.info("Submitted data: {}", userDetails);
    }
}
