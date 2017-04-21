import { Component, OnInit } from '@angular/core';

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

`]
})
export class CreateCourseComponent implements OnInit {

  selectedtype: any;
  categories = ["Math","Science","Programming"];
  constructor() { }

  ngOnInit() {
  }

}
