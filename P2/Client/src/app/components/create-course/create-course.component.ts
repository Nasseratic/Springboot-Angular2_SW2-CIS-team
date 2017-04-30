import { Component, OnInit } from '@angular/core';
import { CourseServiceService } from "../../services/course-service.service"
import { AuthService } from "../../services/auth.service"
import {Router } from '@angular/router'

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html'
  , styles:[ `

.example-full-width {
  width: 100%;
  margin-top: 3px;
  font-size: 1.2em;

}
.example-radio-group {
  display: inline-flex;
  flex-direction: column;
}

.example-radio-button {
  margin: 5px;
}

.example-selected-value {
  margin: 15px 0;
}

`],
providers:[CourseServiceService]
})
export class CreateCourseComponent implements OnInit {

  name='';
  error=false;
  constructor(private courseService: CourseServiceService , private router:Router , public auth:AuthService){

  }



  submit(){
    if(this.name !== ''){
      this.courseService.createCourse(this.name, this.auth.getId() ).subscribe(
      (res) => {
        console.log(res.name + " created!");
        this.router.navigate(['/course/'+res.id]);
    });
      
      }
    else{
      this.error=true;
    }

  }
  ngOnInit() {
  }

}
