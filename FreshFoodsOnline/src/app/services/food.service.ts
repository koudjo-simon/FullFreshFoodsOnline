import {Injectable} from '@angular/core';
import {Observable, of, throwError} from 'rxjs';
import {Food} from 'src/app/shared/model/food';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private foods: Food[] = [
    {
      foodId: "1",
      name: "pizza pepperoni",
      price: 5,
      favorite: true,
      star: 3.5,
      tags: ["FastFood", "Pizza", "Lunch"],
      imageUrl: "./assets/images/food-1.jpg",
      cookTime: "10-12",
      origins: ["Italy"],
      addDate: "",
      foodStatus: "",
      lastModifiedDate: ""
    },
    {
      foodId: "2",
      name: "Hamburger",
      price: 5,
      favorite: false,
      star: 3.5,
      tags: ["FastFood", "Hamburger"],
      imageUrl: "./assets/images/food-2.jpg",
      cookTime: "10-45",
      origins: ["Germany", "US"],
      lastModifiedDate: "",
      foodStatus: "",
      addDate: ""
    },
    {
      foodId: "3",
      name: "fresed patate",
      price: 20,
      favorite: true,
      star: 4.7,
      tags: ["SlowFood", "Lunch"],
      imageUrl: "./assets/images/food-3.jpg",
      cookTime: "20-30",
      origins: ["Persia", "Middle east", "China"],
      addDate: "",
      foodStatus: "",
      lastModifiedDate: ""
    },
    {
      foodId: "4",
      name: "Hamburger",
      price: 12,
      favorite: true,
      star: 4.5,
      tags: ["FastFood", "Hamburger"],
      imageUrl: "./assets/images/food-4.jpg",
      cookTime: "10-15",
      origins: ["Germany", "US"],
      lastModifiedDate: "",
      foodStatus: "",
      addDate: ""
    },
    {
      foodId: "5",
      name: "Vegetables pizza",
      price: 20,
      favorite: false,
      star: 4.0,
      tags: ["FastFood", "Pizza"],
      imageUrl: "./assets/images/food-5.jpg",
      cookTime: "40-50",
      origins: ["Italy"],
      addDate: "",
      foodStatus: "",
      lastModifiedDate: ""
    },
    {
      foodId: "6",
      name: "Spaghetti",
      price: 20,
      favorite: true,
      star: 4.0,
      tags: ["LowFood", "Spaghetti"],
      imageUrl: "./assets/images/food-6.jpg",
      cookTime: "40-50",
      origins: ["Italy"],
      addDate: "",
      foodStatus: "",
      lastModifiedDate: ""
    },
    {
      foodId: "7",
      name: "Spaghetti",
      price: 10,
      favorite: false,
      star: 4.5,
      tags: ["FastFood", "Pizza", "Lunch"],
      imageUrl: "./assets/images/food-7.jpg",
      cookTime: "10-12",
      origins: ["Italy"],
      addDate: "",
      foodStatus: "",
      lastModifiedDate: ""
    },
    {
      foodId: "8",
      name: "pizza pepperoni",
      price: 10,
      favorite: false,
      star: 4.5,
      tags: ["FastFood", "Pizza", "Lunch"],
      imageUrl: "./assets/images/food-8.jpg",
      cookTime: "10-12",
      origins: ["Italy"],
      addDate: "",
      foodStatus: "",
      lastModifiedDate: ""
    }
  ];

  constructor() {
  }

  public getAll(): Observable<Food[]> {
    return of(this.foods);
  }

  public getFoodById(id: string): Observable<Food> {
    let fd = this.foods.find(f => f.foodId == id);
    if (fd == undefined) return throwError(() => new Error("Foods undefined"));
    return of(fd);
  }

  public deleteProductById(id: string): Observable<boolean> {
    this.foods = this.foods.filter(p => p.foodId != id);
    return of(true);
  }

  public editFoodById(food: Food): Observable<Food> {
    this.foods = this.foods.map(f => (f.foodId == food.foodId) ? food : f);
    return of(food);
  }

}
