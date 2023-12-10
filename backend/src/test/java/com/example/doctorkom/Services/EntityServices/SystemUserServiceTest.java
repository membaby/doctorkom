package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.SystemUserMapper;
import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Entities.SystemUser;
import com.example.doctorkom.Repositories.SystemUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SystemUserServiceTest {

    @Mock
    private SystemUserRepository systemUserRepository;

    @Mock
    private SystemUserMapper systemUserMapper;

    @InjectMocks
    private SystemUserService systemUserService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSystemUser() {
        // Arrange
        int userId = 1;
        SystemUserDTO expectedSystemUserDTO = SystemUserDTO.builder().
                id(userId).
                build();
        when(systemUserRepository.findById(userId)).thenReturn(Optional.of(SystemUser.builder().build()));
        when(systemUserMapper.toDto(any())).thenReturn(expectedSystemUserDTO);

        // Act
        SystemUserDTO result = systemUserService.getSystemUser(userId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedSystemUserDTO, result);
        verify(systemUserRepository, times(2)).findById(userId);
        verify(systemUserMapper, times(1)).toDto(any());
    }

    @Test
    public void testUpdateSystemUser() {
        // Arrange
        SystemUserDTO systemUserDTO = SystemUserDTO.builder().build();
        when(systemUserRepository.findById(systemUserDTO.getId())).thenReturn(Optional.of(SystemUser.builder().build()));

        // Act
        systemUserService.updateSystemUser(systemUserDTO);

        // Assert
        verify(systemUserRepository, times(1)).findById(systemUserDTO.getId());
        verify(systemUserRepository, times(1)).save(any());
    }
}
