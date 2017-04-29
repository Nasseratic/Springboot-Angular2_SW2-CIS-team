import { Component, OnInit } from '@angular/core';
import { MdDialog, MdDialogRef } from "@angular/material";
import { AppShellModule } from '@angular/app-shell';
import { ActivatedRoute } from '@angular/router'
import { AppRoutingModule } from '../../routers.module';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [AppShellModule],

})


export class NavbarComponent implements OnInit {

  userName = "";

  constructor(public dialog: MdDialog, private route: ActivatedRoute, private router: Router, public auth: AuthService) { }

  openLoginDialog() {
    this.dialog.open(DialogResultExampleDialog2);
  }

  logout() {
    this.auth.setUser("", "", "");
    this.router.navigate(["/x"]);
  }

  ngOnInit() {
    this.router.events.subscribe(
      () => {
        //this.userName=this.auth.getUser();
        if (this.auth.getUser() !== null) {
          this.userName = this.auth.getUser();
        }
        console.log(this.userName);
      }
    );
    /*this.route
      .queryParams
      .subscribe(params => {
        // Defaults to 0 if no query param provided.
        this.userName = params['user'] || "";
        console.log(params['user']);
        //this.router.navigate(['/home'], { queryParams: {} });

      });
    */

  }



  routToAchievements() {
      this.router.navigate(['/Achievements'] , { queryParams: {} } );
  }


  routToMycourses() {
      this.router.navigate(['/courses'] , { queryParams: {} } );
  }




}



@Component({
  selector: 'dialog-result-example-dialog1',
  templateUrl: 'login-form.html',
  styles: [`

.example-full-width {
  width: 100%;
  margin: 3px;
  min-width: 210px;
  
}
`]
})

export class DialogResultExampleDialog2 {

  email: string;
  pw: string;
  constructor(public dialog: MdDialog, public dialogRef: MdDialogRef<DialogResultExampleDialog2>, private routerM: AppRoutingModule, private auth: AuthService, private router: Router) {


  }



  close() {
    this.dialog.closeAll();
  }

  login() {
    this.auth.login({ "email": this.email, "pw": this.pw }).subscribe(
      (res) => {
        console.log("done!");

        this.auth.setUser(res.name, res.type, res.id);
        console.log(res.name);
        this.close();
        this.router.navigate(['/x']);
      },
      (err) => {
        alert("ERROR! TRY AGAIN !")
        console.log(err);
      }

    );
  }

}


