package com.practice.demo.controller;

import com.practice.demo.entity.Teacher;
import com.practice.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
//    method to save one teacher data
    @PostMapping("/teacher/save")
    public  String saveTeacher(@RequestBody Teacher teacher){
          try{
              teacherService.saveTeacher(teacher);
          }catch ( Exception e) {
              return  "error" + e.getMessage();
          }
          return "success";
    }

    //    method to save All teacher data

    @PostMapping("/teacher/saveAll")
    public  String saveAllTeacher(@RequestBody List<Teacher> teacher){
        try{
            teacherService.saveAllT(teacher);

        }catch ( Exception e) {
            return  "error" + e.getMessage();
        }
        return "success";
    }
    //    method to delete teacher data
    @DeleteMapping("/teacher/delete")
    public  String deleteTeacher(@RequestParam int id){
        try{
            teacherService.deleteTeacher(id);

        }catch ( Exception e) {
            return  "error" + e.getMessage();
        }
        return "success";
    }
    //    method to update teacher data
    @PutMapping("/teacher/update")
    public ResponseEntity<String> UpdateTeacher(@RequestParam int id , @RequestBody Teacher updatedTeacher){
       try {
           teacherService.updatedTeacher(id , updatedTeacher );
           return ResponseEntity.ok("Teacher with ID " + id + " updated successfully.");
//           return  "success";

       }catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error updating student with ID " + id + ": " + e.getMessage());
//           return "error" + e ;

       }

    }



}
