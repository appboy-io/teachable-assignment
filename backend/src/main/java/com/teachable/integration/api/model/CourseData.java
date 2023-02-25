package com.teachable.integration.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CourseData implements Serializable {
    private Course course;
    private List<Users> enrollments;
}
