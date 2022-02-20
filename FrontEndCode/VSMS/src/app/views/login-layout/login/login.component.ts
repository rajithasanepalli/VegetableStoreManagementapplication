import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;


  subscription: any;

  constructor(

    // private persistent: PersistenceService,
    private router: Router, private _myFB: FormBuilder

  ) {


  }

  ngOnInit(): void {

    this.loginForm = this._myFB.group({

      email: ['', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      password: ['', [Validators.required, Validators.minLength(8)]]





    });

  }

  get email(): any {
    return this.loginForm.get('email')
  }
  get password(): any {
    return this.loginForm.get('password')
  }

  doLogin() {
    this.router.navigate(['/dashboard/']);
  }

}
