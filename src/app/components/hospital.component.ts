import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HospitalModel } from '../models/hospital.model';
import { HospitalService } from '../services/hospital.service';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  providers: [HospitalService],
})
export class HospitalComponent implements OnInit {
  formValue!: FormGroup;
  hospitalModel: HospitalModel = new HospitalModel();
  hospitalData!: any;

  constructor(
    private formbuilder: FormBuilder,
    private hospitalService: HospitalService
  ) {}
  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      hospitalName: [''],
      address: [''],
      beds: [''],
      icuBeds: [''],
      contact: [''],
    });
    this.getAllHospitals();
  }

  postHospitalDetails() {
    this.hospitalModel.hospitalName = this.formValue.value.hospitalName;
    this.hospitalModel.address = this.formValue.value.address;
    this.hospitalModel.beds = this.formValue.value.beds;
    this.hospitalModel.icuBeds = this.formValue.value.icuBeds;
    this.hospitalModel.contact = this.formValue.value.contact;

    this.hospitalService.createHospital(this.hospitalModel).subscribe(
      (res) => {
        console.log(res);
        alert('Hospital Created');
        this.formValue.reset();
        this.getAllHospitals();
      },
      (err) => {
        alert('something Went Wrong');
      }
    );
  }
  getAllHospitals() {
    this.hospitalService.getAllHospitals().subscribe((res) => {
      this.hospitalData = res;
    });
  }

  deleteHospital(row: any) {
    this.hospitalService.deleteHosiptal(row.id).subscribe((res) => {
      alert('Hospital Deleted');
      this.getAllHospitals();
    });
  }
}