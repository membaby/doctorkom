package com.example.doctorkom.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.Entities.Clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {

    @Autowired
    ClinicMapper clinicMapper;

    @PostMapping("/create-clinic")
    public String createClinic(@RequestBody ClinicDTO clinicDto)
    {
        Clinic clinic = clinicMapper.toEntity(clinicDto);
        DummyAdminTools dummyAdminTools = new DummyAdminTools();
        String msg = dummyAdminTools.addClinic(clinic);
        return msg;

    }

    @PostMapping("/remove-clinic")
    public String removeClinic(@RequestBody ClinicDTO clinicDto)
    {
        Clinic clinic = clinicMapper.toEntity(clinicDto);
        DummyAdminTools dummyAdminTools = new DummyAdminTools();
        String msg = dummyAdminTools.removeClinic(clinic);
        return msg;

    }
    
}



class DummyAdminTools{
    public String addClinic(Clinic clinic){
        return "";
    }

    public String removeClinic(Clinic clinic){
        return "";
    }
}