package io.lightfeather.management.service;

import io.lightfeather.management.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagementServiceImpl implements ManagementService {

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
        return Arrays.stream(restTemplate.getForObject(supervisorUrl, Person[].class))
                .filter(person -> !person.getJurisdiction().matches("[0-9]+"))
                .sorted(Comparator.comparing(Person::getJurisdiction)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getFirstName))
                .map(person -> person.getJurisdiction() + " - " + person.getLastName() + ", " + person.getFirstName())
                .collect(Collectors.toList());

    }

}
