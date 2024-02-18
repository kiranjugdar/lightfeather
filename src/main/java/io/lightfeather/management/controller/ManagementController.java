package io.lightfeather.management.controller;

import io.lightfeather.management.model.UserDetails;
import io.lightfeather.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagementController {

    @Autowired
    UserService userService;

    @GetMapping("/supervisors")
    public List<String> getSupervisors() {
        return userService.getSupervisors();
    }

    @PostMapping("/submit")
    public void submit(@Valid @RequestBody UserDetails body) {
        System.out.println("Submitted data: " + body.getFirstName() + ", " + body.getLastName() + ", " + body.getSupervisor());
    }
}
