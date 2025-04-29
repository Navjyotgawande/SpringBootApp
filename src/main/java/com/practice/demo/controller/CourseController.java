package com.practice.demo.controller;

import com.practice.demo.entity.Course;
import com.practice.demo.entity.Student;
import com.practice.demo.services.CourseService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    //To save course data
    @PostMapping("/course/save")
    public  ResponseEntity<String> SaveCourse(@RequestBody Course course){

        try {
            courseService.saveC(course);
            return ResponseEntity.ok("Student added successfully.");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }



     @PostMapping("/course/saveAll")
    public String saveAllCourses(@RequestBody List<Course> course){
        try {
            courseService.saveAll(course);
        }catch (Exception e) {
            return  "error" + e.getMessage();
        }
        return  "success";
     }
    //To show course data
    @GetMapping("/course/showAll")
    public ResponseEntity<List<Course>>  ShowCourse() {
        try {
           List<Course> list  =  courseService.getAllCourse();
           if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }else {
           return ResponseEntity.of(Optional.of(list));
           }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while fetching students: " + e.getMessage());
        }

    }

//    To delete course data
    @DeleteMapping("/course/delete")
    public ResponseEntity<String> deleteCourse(@RequestParam int id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
        }catch (Exception e) {
//            throw new RuntimeException("Given id -" + id  + " " + e.getMessage());
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

//    Update the data

    @PutMapping("/course/update")
    public ResponseEntity<String> updateCourse (@RequestParam Integer id , @RequestBody Course updatedCourse ) {
        try {
            courseService.updateCourse(id , updatedCourse);
            return ResponseEntity.ok("Student with ID " + id + " updated successfully.");
        }catch ( Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating student with ID " + id + ": " + e.getMessage());
        }
    }

}
