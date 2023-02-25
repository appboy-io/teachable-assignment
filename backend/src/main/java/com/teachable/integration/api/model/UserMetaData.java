package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class UserMetaData {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("enrolled_at")
    private Timestamp enrolledAt;
    @JsonProperty("completed_at")
    private Timestamp completedAt;
    @JsonProperty("percent_complete")
    private Long percentComplete;
}
