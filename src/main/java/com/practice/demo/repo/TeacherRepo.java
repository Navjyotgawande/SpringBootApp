package com.practice.demo.repo;

import com.practice.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher , Integer> {

}
