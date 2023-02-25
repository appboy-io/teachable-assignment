package com.teachable.integration.api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teachable.integration.api.model.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Log4j2
public class TeachableWrapper {
    private final HttpClient client;

    public List<Course> getAllCourses() {
        Request request = new Request.Builder().url("https://developers.teachable.com/v1/courses?apikey=" + "7JbSA3ep6XOMV3t8t7QXuXq9HS79Dwnr")
                .get().build();

        List<Course> courses = new ArrayList<>();
        try(Response response = client.okHttpClientFactory().newCall(request).execute()) {
            ObjectMapper objectMapper = new ObjectMapper();
            CourseList courseList = objectMapper.readValue(response.body().bytes(), CourseList.class);
            courses = courseList.getCourses();
        } catch(IOException ioException) {
            log.error("Error fetching all courses:", ioException);
        }
        return courses;
    }

    public Course getCourse(Long courseId) {
        Request request = new Request.Builder().url("https://developers.teachable.com/v1/courses/"+ courseId +"?apikey=" + "7JbSA3ep6XOMV3t8t7QXuXq9HS79Dwnr")
                .get().build();
        Course course = null;
        try(Response response = client.okHttpClientFactory().newCall(request).execute()) {
            ObjectMapper objectMapper = new ObjectMapper();
            course = objectMapper.readValue(response.body().bytes(), CourseDetails.class).getCourse();
        } catch(IOException | NullPointerException ioException) {
            log.error("Error fetching course with ID: " + courseId, ioException);
        }
        return course;
    }

    public List<Users> getEnrollments(Long courseId) {
        Request request = new Request.Builder().url("https://developers.teachable.com/v1/courses/"+ courseId +"/enrollments?apikey=" + "7JbSA3ep6XOMV3t8t7QXuXq9HS79Dwnr")
                .get().build();
        Optional<EnrollmentListMeta> enrollmentListMeta = Optional.empty();
        try(Response response = client.okHttpClientFactory().newCall(request).execute()) {
            ObjectMapper objectMapper = new ObjectMapper();
            enrollmentListMeta = Optional.of(objectMapper.readValue(response.body().bytes(), EnrollmentListMeta.class));
        } catch (IOException | NullPointerException exception) {
            log.error("Error fetching enrollments from course with ID: " + courseId, exception);
        }

        List<Users> users = new ArrayList<>();

        try {
            if (enrollmentListMeta.isPresent()) {
                users = enrollmentListMeta.get().getEnrollments().stream().map(UserMetaData::getUserId).map(this::getUser).toList();
            }
        } catch (Exception exception) {
            log.error("Error fetching enrollments user data from course with ID: " + courseId, exception);
        }
        return users;
    }

    private Users getUser(Long userId) {
        Request request = new Request.Builder().url("https://developers.teachable.com/v1/users/"+ userId +"?apikey=" + "7JbSA3ep6XOMV3t8t7QXuXq9HS79Dwnr")
                .get().build();
        Users user = null;
        try(Response response = client.okHttpClientFactory().newCall(request).execute()) {
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(response.body().bytes(), Users.class);
        } catch (IOException | NullPointerException exception) {
            log.error("Error fetching user with ID: " + userId, exception);
        }
        return user;
    }
}
