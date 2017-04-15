import { Component, OnInit } from '@angular/core';
import { CourseServiceService } from './../../services/course-service.service';
import { Router } from '@angular/router'

@Component({
  selector: 'course-cards',
  templateUrl: './course-card.component.html',
  styleUrls: ['./course-card.component.css'],
  providers:[CourseServiceService]
})
export class CourseCardComponent implements OnInit {

  courses = [];
  view_name = "Courses"
  constructor(private service:CourseServiceService , private router : Router ) {


  }

  ngOnInit() {

      this.service.getCourses().subscribe(courses => this.courses = courses);

  }

    viewCourse(id) {
      this.router.navigate(['/course',id]);
  }

}
