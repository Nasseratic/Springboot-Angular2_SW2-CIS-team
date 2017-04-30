import { Component, OnInit } from '@angular/core';
import { CourseServiceService } from './../../services/course-service.service';
import { AuthService } from './../../services/auth.service';
import { Router } from '@angular/router'
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'course-cards',
  templateUrl: './course-card.component.html',
  styleUrls: ['./course-card.component.css'],
  providers:[CourseServiceService]
})
export class CourseCardComponent implements OnInit {

  courses = [];
  view_name = "ALL COURSES";
  id : any;

  constructor(private service:CourseServiceService , private router: Router, private aRouter: ActivatedRoute , private auth:AuthService) {


  }

  ngOnInit() {


    let id = this.aRouter.snapshot.params['id'];
    this.id = id;

    if (id) {
      this.service.getCoursesByTeacher(id).subscribe(courses => this.courses = courses);      
    }
    else {
      this.service.getCourses().subscribe(courses => this.courses = courses);      
    }

  }

    viewCourse(id) {
      this.router.navigate(['/course',id]);
  }


addButton(){
  if( this.auth.getType() == 'Teacher')
  return true;
  else
  return false;
}


}
