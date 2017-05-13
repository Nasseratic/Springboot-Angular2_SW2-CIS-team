package com.restful.hello.course;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CourseService {

    public static final Logger logger = LoggerFactory.getLogger(CourseModel.class);

    @Autowired
    private CourseModel courseModel;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/create/course", method = RequestMethod.POST)
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        logger.info("Creating Game : {}", course.getName());
        courseModel.save(course);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getCourses(){
        logger.info("requesting All Courses");
        List<Course> all = (List<Course>) courseModel.findAll();
        return new ResponseEntity<List<Course>>(all, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getCourseByTeacher(@PathVariable  int id){
        logger.info("requesting courses for Teacher");
        List<Course> courses =  courseModel.findByTeacherId(id);
        logger.info( courses.size()+"courses for this Teacher");
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/ismycourse/{courseId}/{teacherId}", method = RequestMethod.GET)
    public ResponseEntity<Integer> isMyCourse(@PathVariable int courseId, @PathVariable int teacherId) {
        logger.info("IS my course ?");
            if (courseModel.findOne(courseId).getTeacherId() == teacherId)
                return new ResponseEntity<Integer>(1, HttpStatus.OK);
            else
                return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<Course> getGame(@PathVariable Integer id){
        logger.info("requesting course : {}", id);
        Course course =courseModel.findOne(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


}

