package com.example.springbd3big.course.controller;

import com.example.springbd3big.course.model.Course;
import com.example.springbd3big.course.repository.CourseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses/archive")
@Tag(name = "Course archive", description = "Archived courses. Requires course:read.")
public class CourseArchiveController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    @Operation(summary = "Get archived courses", description = "Required permission: course:read", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Course> getArchivedCourses() {
        return courseRepository.findAll();
    }
}
