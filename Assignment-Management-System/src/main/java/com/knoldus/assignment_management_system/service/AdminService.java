package com.knoldus.assignment_management_system.service;

import com.knoldus.assignment_management_system.model.InternMentorMap;
import com.knoldus.assignment_management_system.model.KipKup;

public interface AdminService {
    KipKup createPlan(KipKup kipKupPlan);
    KipKup updatePlan(KipKup kipKupPlan);
    InternMentorMap addInternMentor(InternMentorMap internMentorMap);
    InternMentorMap updateInternMentor(InternMentorMap internMentorMap, Long mentorId);
}
