package com.practice.demo.services;

import com.practice.demo.entity.Student;
import com.practice.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
//    method to save data for one student
    public  void saveS(Student student){

        studentRepo.save(student);
    }
    //    method to save data for more than one student
    public  void saveAll(List<Student> student){
        studentRepo.saveAll(student);
    }
    //    method to show data for one student
    public Optional<Student> showOne(Integer id) {
        return studentRepo.findById(id);
    }
    //    method to delete data for one student from list
    public  Optional<Student> deleteOne(Integer id){
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentRepo.deleteById(id);
            return  studentOptional;
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }

    }
    //    method to update data for one student
    public void updateStudent(Integer id, Student updatedStudent) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            // Update other fields as needed
            studentRepo.save(existingStudent);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }
    }

    public List<Student> getAllStudents() {
        try {
            return studentRepo.findAll();
        } catch (Exception e) {
            // Log the error or handle it appropriately
            e.printStackTrace();
            throw new RuntimeException("Error occurred while fetching students: " + e.getMessage());
        }
    }
}
