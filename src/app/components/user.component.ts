import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserModel } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  providers: [UserService],
})
export class UserComponent implements OnInit {
  formValue!: FormGroup;
  userModel: UserModel = new UserModel();
  userData!: any;

  constructor(
    private formbuilder: FormBuilder,
    private userService: UserService
  ) {}
  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      name: [''],
      email: [''],
      userName: [''],
      password: [''],
      mobile: [''],
    });
    this.getAllUsers();
    this.formValue = new FormGroup({
      name: new FormControl(null, Validators.required),
      email: new FormControl(null, [Validators.required, Validators.email]),
      mobile: new FormControl(null, [
        Validators.required,
        Validators.pattern(
          '^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$'
        ),
      ]),
      userName: new FormControl(null, [
        Validators.required,
        Validators.minLength(5),
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(5),
      ]),
    });
  }

  postUserDetails() {
    this.userModel.name = this.formValue.value.name;
    this.userModel.email = this.formValue.value.email;
    this.userModel.userName = this.formValue.value.userName;
    this.userModel.password = this.formValue.value.password;
    this.userModel.mobile = this.formValue.value.mobile;

    this.userService.createUser(this.userModel).subscribe(
      (res) => {
        console.log(res);
        alert('user Created');
        this.formValue.reset();
        this.getAllUsers();
      },
      (err) => {
        alert('something Went Wrong');
      }
    );
  }
  getAllUsers() {
    this.userService.getAllUsers().subscribe((res) => {
      this.userData = res;
    });
  }

  deleteUser(row: any) {
    this.userService.deleteUser(row.id).subscribe((res) => {
      alert('User Deleted');
      this.getAllUsers();
    });
  }
  get name() {
    return this.formValue.get('name');
  }
  get email() {
    return this.formValue.get('email');
  }
  get mobile() {
    return this.formValue.get('mobile');
  }
  get userName() {
    return this.formValue.get('userName');
  }
  get password() {
    return this.formValue.get('password');
  }
}