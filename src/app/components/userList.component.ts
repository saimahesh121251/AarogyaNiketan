import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserModel } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-userList',
  templateUrl: './userList.component.html',
  providers: [UserService],
})
export class UserListComponent implements OnInit {
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
        alert('Employee Created');
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

  onEdit(row: any) {
    this.userModel.id = row.id;
    this.formValue.controls['name'].setValue(row.name);
    this.formValue.controls['email'].setValue(row.email);
    this.formValue.controls['userName'].setValue(row.userName);
    this.formValue.controls['password'].setValue(row.password);
    this.formValue.controls['mobile'].setValue(row.mobile);
  }

  updateUserDetails() {
    this.userModel.name = this.formValue.value.name;
    this.userModel.email = this.formValue.value.email;
    this.userModel.userName = this.formValue.value.userName;
    this.userModel.password = this.formValue.value.password;
    this.userModel.mobile = this.formValue.value.mobile;
    this.userService
      .updateUser(this.userModel, this.userModel.id)
      .subscribe((res) => {
        alert('User Details Updated');

        this.formValue.reset();
        this.getAllUsers();
      });
  }
}