package com.knoldus.assignment_management_system;

import com.knoldus.assignment_management_system.dao.InternMentorRepository;
import com.knoldus.assignment_management_system.dao.InternRepository;
import com.knoldus.assignment_management_system.dao.KipKupRepository;
import com.knoldus.assignment_management_system.dao.MentorRepository;
import com.knoldus.assignment_management_system.model.Intern;
import com.knoldus.assignment_management_system.model.InternMentorMap;
import com.knoldus.assignment_management_system.model.InternMentorMapId;
import com.knoldus.assignment_management_system.model.KipKup;
import com.knoldus.assignment_management_system.service.serviceimpl.AdminServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdminServiceImplTest {
    @Mock
    KipKupRepository kipKupRepository;
    @Mock
    InternRepository internRepository;
    @Mock
    MentorRepository mentorRepository;
    @Mock
    InternMentorRepository internMentorRepository;

    @InjectMocks
    private AdminServiceImpl adminService;


    private KipKup kipKup;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        kipKup=new KipKup(30L, LocalTime.now(),"shiv", LocalDate.now(),"java","springboot");
    }
    @Test
    public void testCreatePlan(){
        when(kipKupRepository.save(kipKup))
                .thenReturn(kipKup);
        KipKup saveRecords=adminService.createPlan(kipKup);
        assertEquals(kipKup,saveRecords);
    }
    @Test
    public void testUpdatePlan_ExistingPlan_ReturnsUpdatedPlan() {

        KipKup existingPlan = new KipKup(30L, LocalTime.now(),"shiv", LocalDate.now(),"java","springboot");
        KipKup updatedPlan = new KipKup(30L, LocalTime.now(),"sakshi", LocalDate.now(),"java","springboot");

        Mockito.when(kipKupRepository.findById(30L)).thenReturn(Optional.of(existingPlan));
        Mockito.when(kipKupRepository.save(updatedPlan)).thenReturn(updatedPlan);


        KipKup result = adminService.updatePlan(updatedPlan);

        assertEquals(updatedPlan, result);
        verify(kipKupRepository, times(1)).findById(30L);
        verify(kipKupRepository, times(1)).save(updatedPlan);
    }
    @Test
    public void testAddInternMentor_ValidInternAndMentor_ReturnsMappedObject() {

        long internId = 10L;
        long mentorId = 12L;
        InternMentorMap internMentorMap = new InternMentorMap(internId, mentorId, LocalDate.now(),LocalDate.now());

        Mockito.when(internRepository.existsById(internId)).thenReturn(true);
        Mockito.when(mentorRepository.existsById(mentorId)).thenReturn(true);
        Mockito.when(internMentorRepository.save(internMentorMap)).thenReturn(internMentorMap);


        InternMentorMap result = adminService.addInternMentor(internMentorMap);


        assertEquals(internMentorMap, result);
        verify(internRepository, times(1)).existsById(internId);
        verify(mentorRepository, times(1)).existsById(mentorId);
        verify(internMentorRepository, times(1)).save(internMentorMap);
    }
    @Test
    void testUpdateInternMentor_Success() {

        Long mentorId = 123L;
        InternMentorMap internMentorMap = new InternMentorMap();
        internMentorMap.setIntern(121L);


        when(internRepository.findById(internMentorMap.getIntern())).thenReturn(Optional.of(new Intern()));
        when(internMentorRepository.save(internMentorMap)).thenReturn(internMentorMap);


        InternMentorMap result = adminService.updateInternMentor(internMentorMap, mentorId);


        verify(internMentorRepository, times(1)).save(internMentorMap);


        assertEquals(mentorId, result.getMentor());
    }
}