package com.knoldus.assignment_management_system;

import com.knoldus.assignment_management_system.dao.MentorRepository;
import com.knoldus.assignment_management_system.model.Mentor;
import com.knoldus.assignment_management_system.service.serviceimpl.MentorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;

class MentorServiceImplTest {

    @Mock
    MentorRepository mentorRepository;

    @InjectMocks
    private MentorServiceImpl mentorService;

    @Captor
    private ArgumentCaptor<Long> idCaptor;

    private Mentor mentor;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        mentor = new Mentor(12L, "123", "java", LocalDateTime.now(), LocalDateTime.now());

    }

    @Test
     void testAddMentorDetails(){
        when(mentorRepository.save(mentor))
                .thenReturn(mentor);
        Mentor saveRecords = mentorService.addMentorDetails(mentor);
        Assertions.assertEquals(mentor, saveRecords);
    }

    @Test
    public void testGetMentors(){
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(mentor);
        mentorList.add(new Mentor(12L, "11", "java", LocalDateTime.now(), LocalDateTime.now()));

        when(mentorRepository.findAll())
                .thenReturn(mentorList);
        List<Mentor> testMentorList = mentorService.getMentors();
        Assertions.assertEquals(mentorList, testMentorList);

    }

    @Test
     void testDeleteExistingMentorById() {
        Long mentorId = 12L;

        when(mentorRepository.findById(mentorId))
                .thenReturn(Optional.of(new Mentor(12L, "12", "java", LocalDateTime.now(), LocalDateTime.now())));

        mentorService.deleteMentorById(mentorId);

        verify(mentorRepository).deleteById(idCaptor.capture());
        Long capturedId = idCaptor.getValue();
        Assertions.assertEquals(mentorId, capturedId);

        String expected = "mentor id " + mentorId + " successfully";
        Assertions.assertEquals(expected, "mentor id " + capturedId + " successfully");
    }

    @Test
     void testGetMentorDetailById(){
        Mentor mentorToGet = new Mentor(
                12L, "12", "java", LocalDateTime.now(), LocalDateTime.now());
        when(mentorRepository.findById(anyLong()))
                .thenReturn(Optional.of(mentorToGet));

        Mentor retrievedMentor = mentorService.getMentorDetail(12L);
        verify(mentorRepository).findById(12L);
        Assertions.assertEquals(mentorToGet, retrievedMentor);

    }
}