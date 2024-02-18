package io.lightfeather.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.List;

@Service
public class ManagementService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${supervisor.url}")
    private String supervisorUrl;


    /**
     *
     * This function returns a list of supervisor :
     *  Strings formatted “jurisdiction - lastName, firstName”
     *  Supervisors within the endpoint response payload should be sorted in alphabetical order
     *      first by jurisdiction, then by lastName and firstName.
     *  Numeric jurisdictions should be excluded from the response.
     *
     * @return List of supervisors / managers sorted by jurisdiction, last name, first name
     */
    public List<String> getSupervisors() {
        List<Map<String, Object>> managers = restTemplate.getForObject(supervisorUrl, List.class);
        List<String> supervisors = new ArrayList<>();
        for (Map<String, Object> manager : managers) {
            if (!manager.containsKey("jurisdiction") || !((String) manager.get("jurisdiction")).matches("^[a-zA-Z]+$")) { continue; }
            supervisors.add(String.format("%s - %s, %s", manager.get("jurisdiction"), manager.get("lastName"), manager.get("firstName")));
        }
        Collections.sort(supervisors);
        return supervisors;
    }

}