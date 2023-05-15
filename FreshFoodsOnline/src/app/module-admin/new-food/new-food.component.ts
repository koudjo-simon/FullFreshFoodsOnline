import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MyValidatorsService } from '../../services/my-validators.service';

@Component({
  selector: 'app-new-food',
  templateUrl: './new-food.component.html',
  styleUrls: ['./new-food.component.scss']
})
export class NewFoodComponent implements OnInit {

  public foodFormGroup! : FormGroup;

  constructor(private fb: FormBuilder, public myValService: MyValidatorsService){}

  ngOnInit(): void {
      this.foodFormGroup = this.fb.group({
        name: ['', Validators.required],
        price: ['', Validators.required, Validators.min(0)],
        tags: ['', Validators.required],
        imageUrl: ['', Validators.required],
        hours: ['', Validators.required, Validators.min(0), Validators.max(23)],
        minutes: ['', Validators.required, Validators.min(0), Validators.max(59)],
        origins: ['', Validators.required],
        star: ['1', Validators.required],
        favorite: ['False', Validators.required],
      })
  }

  handleSubmit(){
    
  }

}
