package org.michisoft.backendclassroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.michisoft.backendclassroom.domain.Subject;
import org.michisoft.backendclassroom.dto.SubjectDTO;
import org.michisoft.backendclassroom.problem.exception.SubjectAlreadyExistsException;
import org.michisoft.backendclassroom.repository.SubjectRepository;
import org.michisoft.backendclassroom.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper subjectMapper;

    @Override
    public SubjectDTO save(SubjectDTO subjectDTO) {
        if (subjectRepository.existsByCode(subjectDTO.getCode())) {
            throw new SubjectAlreadyExistsException(
                    String.format("Code %s already exists", subjectDTO.getCode()));
        }

        Subject subjectToPersist = subjectMapper.map(subjectDTO, Subject.class);
        Subject subjectPersisted = subjectRepository.save(subjectToPersist);
        return subjectMapper.map(subjectPersisted, SubjectDTO.class);
    }
}
