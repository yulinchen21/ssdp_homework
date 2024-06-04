import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Product} from "../interface/Product";
import {Observable} from "rxjs";

@Injectable({
  providedIn: "root"
})
export class ProductListApiService {
  constructor(private httpClient: HttpClient) {}

  getProducts(page: number, size: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`/products?page=${page}&size=${size}`);
  }
}
