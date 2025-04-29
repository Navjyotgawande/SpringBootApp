package com.practice.demo.repo;

import com.practice.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course , Integer> {
}
