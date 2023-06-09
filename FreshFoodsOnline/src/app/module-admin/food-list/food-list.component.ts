import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FoodService } from 'src/app/services/food.service';
import { Food } from 'src/app/shared/model/food';
import { Admin } from '../admin-model/admin';
import { AuthenticationService } from '../admin-services/authentication/authentication.service';

@Component({
  selector: 'app-food-list',
  templateUrl: './food-list.component.html',
  styleUrls: ['./food-list.component.scss']
})
export class FoodListComponent implements OnInit{

  public authAdmin!: Admin;
  public foods: Food[] = [];
  public errorMessage!: string;
  private _searchKeyword: string = "";
  public searchFoods: Food[] = [];

  constructor(private foodService: FoodService,
    private router: Router,
    private authService: AuthenticationService){}

  ngOnInit(): void {
    this.authService.getAuthenticatedUser().subscribe({
      next: user => this.authAdmin = user,
      error: err => console.log(err)
    });

    this.foodService.getAll().subscribe({
      next: (fds) => {
        this.foods = fds;
        this.searchFoods = this.foods;
        console.log(this.foods);
      },
      error: err => {
        console.error(err);
        this.errorMessage = err;
      }
    });
  }

  public get searchKeyword(): string{
    return this._searchKeyword;
  }

  public set searchKeyword(keyword: string){
    this._searchKeyword = keyword;
    this.searchFoods = this.searchKeyword ? this.filterFoods(this.searchKeyword) : this.foods;
  }

  private filterFoods(criteria: string): Food[]{
    criteria = criteria.toLowerCase();
    const res = this.foods.filter(
      (food: Food) => food.name.toLowerCase().indexOf(criteria) != -1
    );
    return res;
  }

  handleDeleteFood(f: Food){
    let conf = confirm("Are you sure that you want to delete food "+f.name+" ?");
    if (conf == false) return;
    this.foodService.deleteProductById(f.foodId).subscribe({
      next : data => {
        let index = this.foods.indexOf(f);
        this.foods.splice(index, 1);
      }
    });
  }

  handleEditFood(f: Food){
    if (this.authAdmin != undefined) {
      let url = "/admin/"+ this.authAdmin.username + "/food/"+ "edit/" + f.foodId;
      this.router.navigateByUrl(url);
    }
  }

}
