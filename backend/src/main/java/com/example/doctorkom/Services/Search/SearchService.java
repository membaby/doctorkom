package com.example.doctorkom.Services.Search;

import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import com.example.doctorkom.EntitySearch.SearchFilter;
import com.example.doctorkom.EntitySearch.SearchSpecification;
import com.example.doctorkom.Services.ClinicServices.ClinicService;
import com.example.doctorkom.Services.EntityServices.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
    @Autowired
    DoctorService doctorService;
    // ClinicService clinicService
    @Autowired
    ClinicService clinicService;

    // @Autowired
    // public SearchService(DoctorService doctorService, ClinicService clinicService) {
    //     this.doctorService = doctorService;
    //     this.clinicService = clinicService;
    // }

    public Page<DoctorDTO> searchDoctors(Map<String, String> searchParams, int pageCount) {
        return doctorService.findAllDoctors(createSearchSpecification(searchParams), pageCount);
    }

    public Page<ClinicDTO> searchClinics(Map<String, String> searchParams, int pageCount) {
        return clinicService.findAllClinics(createSearchSpecification(searchParams), pageCount);
    }

    public Page<DoctorDTO> searchDoctorsByDoctorAndClinic(Map<String, String> searchParams, int pageCount) {
        return doctorService.findAllDoctors(searchParams.get("name"), searchParams.get("city"),
                searchParams.get("specialty") != null?DoctorSpecialty.valueOf(searchParams.get("specialty")):null,
                searchParams.get("title") != null?DoctorTitle.valueOf(searchParams.get("title")):null, pageCount);
    }

    private <T> Specification<T> createSearchSpecification(Map<String, String> searchParams) {
        SearchSpecification<T> searchSpecification = new SearchSpecification<>();
        List<Specification<T>> specifications = new ArrayList<>();
        for (Map.Entry<String, String> entry : searchParams.entrySet()) {
            SearchFilter searchFilter = SearchFilter.builder().field(entry.getKey()).operator(SearchFilter.QueryOperator.LIKE).value(entry.getValue()).build();
            specifications.add(searchSpecification.createSpecification(searchFilter));
        }
        return searchSpecification.intersection(specifications);
    }
}