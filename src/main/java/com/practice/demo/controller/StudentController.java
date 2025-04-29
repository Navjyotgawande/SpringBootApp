package com.practice.demo.controller;

import com.practice.demo.entity.Student;
import com.practice.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
   private StudentService studentService;
    @PostMapping("/student/save")
    public  String saveStudents(@RequestBody Student student){

        try {
            studentService.saveS(student);
        }catch (Exception e){
            return  "error" + e.getMessage();
        }
        return "success";
    }

    @GetMapping("/student/showAll")
    public List<Student> showAllStudents() {
        try {
            return studentService.getAllStudents();
        } catch (Exception e) {
            // Log the error or handle it appropriately
            e.printStackTrace();
            throw new RuntimeException("Error occurred while fetching students: " + e.getMessage());
        }
    }
    @PostMapping("/student/saveAll")
    public  String saveAllStudents(@RequestBody List<Student> student){

        try {
            studentService.saveAll(student);
        }catch (Exception e){
            return  "error" + e.getMessage();
        }
        return "success";
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Object> showOneStudent(@PathVariable Integer id) {
        try {
            Optional<Student> student = studentService.showOne(id);
            if (student != null) {
                System.out.println("Retrieved data of student with ID " + id + ": " + student.toString());
                return ResponseEntity.ok(student);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/student/delete")
    public  String deleteOneStudent(@RequestParam Integer id){

        try {
            studentService.deleteOne(id);
        }catch (Exception e){
            return  "error" + e.getMessage();
        }
        return "success";
    }
    @PutMapping("/student/update")
    public ResponseEntity<String> updateStudent(@RequestParam Integer id, @RequestBody Student updatedStudent) {
        try {
            studentService.updateStudent(id, updatedStudent);
            return ResponseEntity.ok("Student with ID " + id + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating student with ID " + id + ": " + e.getMessage());
        }
    }


}
