package com.Ha.Anh.service;

import com.Ha.Anh.model.Student;
import com.Ha.Anh.model.Subject;
import com.Ha.Anh.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }

    public boolean isSubjectIDExists(String subjectID) {
        return subjectRepository.existsById(subjectID);
    }

    public Subject save(Subject subject) {
        // Lưu hoặc cập nhật sinh viên
        return subjectRepository.save(subject);
    }
}
