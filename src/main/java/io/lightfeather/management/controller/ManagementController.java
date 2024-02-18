package io.lightfeather.management.controller;

import io.lightfeather.management.model.UserDetails;
import io.lightfeather.management.service.ManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
@Tag(name = "Management", description = "API for management service")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    Logger logger = LoggerFactory.getLogger(ManagementController.class);


    @Operation(
            summary = "Get list of supervisors",
            description = "Returns list of supervisors Jurisdiction - LastName, FirstName")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/supervisors")
    public List<String> getSupervisors() {
        return managementService.getSupervisors();
    }

    @Operation(
            summary = "Submit supervisor",
            description = "Validates required information passed to supervisor and submit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/submit")
    public void submit(@Valid @RequestBody UserDetails userDetails) {
        logger.info("Submitted data: {}", userDetails);
    }
}
