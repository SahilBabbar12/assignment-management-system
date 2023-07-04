package com.knoldus.assignment_management_system;

import com.knoldus.assignment_management_system.dao.InternRepository;
import com.knoldus.assignment_management_system.model.Intern;
import com.knoldus.assignment_management_system.service.serviceimpl.InternServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InternServiceImplTest {
    @Mock
    InternRepository internRepository;
    @InjectMocks
    private InternServiceImpl internService;

    @Captor
    private ArgumentCaptor<Long> idCaptor;
    private  Intern intern;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        intern=new Intern(10L,101L,"sahil", "babbar","java","springboot",
                LocalDateTime.now(),LocalDateTime.now());
    }
    @Test
    void testAddInternDetails(){
        when(internRepository.save(intern))
                .thenReturn(intern);
        Intern saveRecords=internService.addNewIntern(intern);
        Assertions.assertEquals(intern,saveRecords);
    }
    @Test
    public void testGetInterns(){
        List<Intern> internList=new ArrayList<>();
        internList.add(intern);
        internList.add(new Intern(11L,102L,"rahul","kumar","java","azure", LocalDateTime.now(),LocalDateTime.now()));
    }

    @Test
    void testDeleteExistingInternById(){
        Long internId=11L;
        when(internRepository.findById(internId))
                .thenReturn(Optional.of(new Intern(11L,102L,"rahul","kumar",
                        "java","azure", LocalDateTime.now(),LocalDateTime.now())));
        internService.deleteIntern(internId);
        verify(internRepository).deleteById(idCaptor.capture());
        Long capturedId=idCaptor.getValue();
        Assertions.assertEquals(internId,capturedId);
        String expected="intern Id "+internId+" deleted successfully";
        Assertions.assertEquals(expected,"intern Id "+capturedId +" deleted successfully");
    }
    @Test
    void testGetInternDetailById() {
        Intern interntoGet = new Intern(
                11L,102L,"rahul","kumar",
                "java","azure", LocalDateTime.now(),LocalDateTime.now());
        when(internRepository.findById(anyLong()))
                .thenReturn(Optional.of(interntoGet));

        Intern retrievedIntern = internService.getInternDetail(11L);
        verify(internRepository).findById(11L);
        Assertions.assertEquals(interntoGet, retrievedIntern);

    }
    @Test
    public void testUpdateMentor_ExistingMentor_ReturnsUpdatedMentor() {
        // Arrange

        Intern existingIntern = new Intern(11L,102L,"rahul","kumar",
                "java","azure", LocalDateTime.now(),LocalDateTime.now());
        Intern updatedIntern = new Intern(11L,102L,"jasleen","kumar",
                "java","azure", LocalDateTime.now(),LocalDateTime.now());

        Mockito.when(internRepository.findById(12L)).thenReturn(Optional.of(existingIntern));
        Mockito.when(internRepository.save(updatedIntern)).thenReturn(updatedIntern);

        // Act
        Intern result = internService.updateIntern(updatedIntern);

        // Assert
        Assertions.assertEquals(updatedIntern, result);
        Mockito.verify(internRepository, Mockito.times(1)).findById(12L);
        Mockito.verify(internRepository, Mockito.times(1)).save(updatedIntern);
    }

}