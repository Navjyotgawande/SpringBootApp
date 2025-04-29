package com.practice.demo.services;

import com.practice.demo.entity.Course;
import com.practice.demo.entity.Student;
import com.practice.demo.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    //   method to save data for one course
    public  void saveC(Course course){

        courseRepo.save(course);
    }

    public List<Course> getAllCourse() {
        try {
            return courseRepo.findAll();
        } catch (Exception e) {
            // Log the error or handle it appropriately
            e.printStackTrace();
            throw new RuntimeException("Error occurred while fetching students: " + e.getMessage());
        }
    }

    public void saveAll(List<Course> course) {
        courseRepo.saveAll(course);
    }

    //Delete co
    public Object deleteCourse(int id) {
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if (optionalCourse.isPresent()) {

            courseRepo.deleteById(id);
            return  optionalCourse;
        }else  {
            throw new RuntimeException("Student with id" + id + "not found");
        }
    }

    public void updateCourse(Integer id, Course updatedCourse) {
       Optional<Course> optionalCourse = courseRepo.findById(id);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setCourseName(updatedCourse.getCourseName());
            // Update other fields as needed
            courseRepo.save(existingCourse);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }
    }
}
