package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CourseList {
    @JsonProperty("courses")
    private List<Course> courses;
    @JsonProperty("meta")
    private MetaData meta;
}
