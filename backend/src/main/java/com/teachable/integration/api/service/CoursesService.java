package com.teachable.integration.api.service;

import com.teachable.integration.api.model.Course;
import com.teachable.integration.api.model.CourseData;
import com.teachable.integration.api.model.Users;
import com.teachable.integration.api.utils.TeachableWrapper;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private final TeachableWrapper teachableWrapper;

    private final RedisTemplate<String, CourseData> courseDataCache;
    private final RedisTemplate<String, List<Course>> coursesCache;
    public List<Course> getAllCourses() {
        List<Course> result = teachableWrapper.getAllCourses();

        coursesCache.opsForValue().set("all", result);
        return teachableWrapper.getAllCourses();
    }

    public CourseData getCourse(Long courseId) {
        Course course = teachableWrapper.getCourse(courseId);
        List<Users> enrollments = teachableWrapper.getEnrollments(courseId);

        CourseData courseData = new CourseData();
        courseData.setCourse(course);
        courseData.setEnrollments(enrollments);

        courseDataCache.opsForValue().set(String.valueOf(courseId), courseData);
        return courseData;
    }
}
