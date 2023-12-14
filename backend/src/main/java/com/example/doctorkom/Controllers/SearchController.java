package com.example.doctorkom.Controllers;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Services.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/doctors")
    public List<Doctor> searchDoctors(@RequestParam Map<String, String> searchParams) {
        return searchService.searchDoctorsByDoctorAndClinic(searchParams);
    }

    @GetMapping("/clinics")
    public List<Clinic> searchClinics(@RequestParam Map<String, String> searchParams) {
        return searchService.searchClinics(searchParams);
    }
}
