package org.michisoft.backendclassroom.service;

import org.michisoft.backendclassroom.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    List<TeacherDTO> getAllTeacher(int page, int size);
}
