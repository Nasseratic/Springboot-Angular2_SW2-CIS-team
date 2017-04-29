package com.restful.hello.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseModel extends CrudRepository<Course,Integer> {
    public List<Course> findByTeacherId(Integer id);
}
