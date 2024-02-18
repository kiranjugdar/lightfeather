package io.lightfeather.management.service;

import io.lightfeather.management.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public interface ManagementService {
    List<String> getSupervisors();
}