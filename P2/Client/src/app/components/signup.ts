import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service'
import { Router } from '@angular/router'

@Component({
  selector: 'sign-up',
  templateUrl: './signup.html'
  , styles: [`

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

})
export class SignUp implements OnInit {

  selectedtype: string;

  types = [
    'Student',
    'Teacher'
  ];

  user = {
    'id': '',
    'name': '',
    'email': '',
    'pw': '',
    'type':''
  };

  error = false;
  constructor(private auth: AuthService, private router: Router) {

  }

  ngOnInit() {
  }


  submit() {
    if(
      this.user.name !== '' &&
      this.user.email !=='' && 
      this.user.pw !== '' &&
      this.user.type !== ''
    
     ){

      this.auth.signUp(this.user).subscribe(
      (res) => {
      console.log("done!");
      this.auth.setUser(this.user.name , this.user.type , res.id );
      console.log(this.user.name);
      this.router.navigate(['/']);
      
    },
    (err) =>
    alert("error !!")
    );}
    else{
        this.error = true;  
    }

  }

}
