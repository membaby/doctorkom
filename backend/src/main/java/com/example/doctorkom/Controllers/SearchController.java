package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Services.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<DoctorDTO> searchDoctors(@RequestParam Map<String, String> searchParams, @RequestParam int pageCount) {
        return searchService.searchDoctorsByDoctorAndClinic(searchParams, pageCount);
    }

    @GetMapping("/clinics")
    public Page<ClinicDTO> searchClinics(@RequestParam Map<String, String> searchParams, @RequestParam int pageCount) {
        return searchService.searchClinics(searchParams, pageCount);
    }
}
