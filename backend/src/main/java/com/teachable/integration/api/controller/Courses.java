package com.teachable.integration.api.controller;

import com.teachable.integration.api.model.Course;
import com.teachable.integration.api.model.CourseData;
import com.teachable.integration.api.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RequestMapping("/courses")
@AllArgsConstructor
public class Courses {

    private final CoursesService service;
    private final RedisTemplate<String, CourseData> courseDataCache;
    private final RedisTemplate<String, List<Course>> coursesCache;
    @GetMapping
    public List<Course> getAllCourses() {
        List<Course> courses = coursesCache.opsForValue().get("all");
        if (!Objects.isNull(courses) && !courses.isEmpty()) {
            return courses;
        } else {
            return service.getAllCourses();
        }
    }

    @GetMapping("/{courseId}")
    public CourseData getCourse(@PathVariable("courseId") Long courseId) {
        CourseData courseData = courseDataCache.opsForValue().get(String.valueOf(courseId));
        return Objects.isNull(courseData) ? service.getCourse(courseId) : courseData;
    }
}
