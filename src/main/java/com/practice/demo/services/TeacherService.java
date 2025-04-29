package com.practice.demo.services;

import com.practice.demo.entity.Student;
import com.practice.demo.entity.Teacher;
import com.practice.demo.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

@Autowired
private TeacherRepo teacherRepo;
//Method to save teacher data
public  void  saveTeacher(Teacher teacher){
    teacherRepo.save(teacher);
}

    public void saveAllT(List<Teacher> teacher) {
    teacherRepo.saveAll(teacher);
    }

    public Object deleteTeacher(int id) {
        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        if (optionalTeacher.isPresent()) {
            teacherRepo.deleteById(id);
            return  optionalTeacher;
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }
    }
    public  Object updatedTeacher(int id , Teacher updatedTeacher) {
    Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isPresent()) {
            Teacher existingTeacher = teacherOptional.get();
            existingTeacher.setAddress(updatedTeacher.getAddress());
            existingTeacher.setSalary(updatedTeacher.getSalary());
            // Update other fields as needed
            teacherRepo.save(existingTeacher);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }
        return  "success";
    }
}
