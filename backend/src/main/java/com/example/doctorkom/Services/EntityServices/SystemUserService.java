package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.SystemUserMapper;
import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserService {
    private final SystemUserMapper systemUserMapper;
    private final SystemUserRepository systemUserRepository;

    @Autowired
    public SystemUserService(SystemUserMapper systemUserMapper, SystemUserRepository systemUserRepository) {
        this.systemUserMapper = systemUserMapper;
        this.systemUserRepository = systemUserRepository;
    }

    public SystemUserDTO getSystemUser(int id) {
        if (systemUserRepository.findById(id).isPresent()) {
            return systemUserMapper.toDto(systemUserRepository.findById(id).get());
        }
        return null;
    }

    public void updateSystemUser(SystemUserDTO systemUserDTO) {
        if (systemUserRepository.findById(systemUserDTO.getId()).isPresent()) {
            systemUserRepository.save(systemUserMapper.toEntity(systemUserDTO));
        }
    }
}
