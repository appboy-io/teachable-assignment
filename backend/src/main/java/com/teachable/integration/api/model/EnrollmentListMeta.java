package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EnrollmentListMeta {
    @JsonProperty("enrollments")
    private List<UserMetaData> enrollments;
    @JsonProperty("meta")
    private MetaData meta;
}
