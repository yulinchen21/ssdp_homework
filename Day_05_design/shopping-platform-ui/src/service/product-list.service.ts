import {Injectable} from "@angular/core";
import {ProductListApiService} from "../api-service/product-list-api.service";
import {Observable} from "rxjs";
import {Product} from "../interface/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductListService {
  constructor(private productListApiService: ProductListApiService) {}

  getProducts(page: number, size: number): Observable<Product[]> {
    return this.productListApiService.getProducts(page,size);
  }
}
