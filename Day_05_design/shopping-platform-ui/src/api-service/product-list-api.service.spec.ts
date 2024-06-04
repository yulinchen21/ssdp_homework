import {TestBed} from '@angular/core/testing';
import {ProductListApiService} from "./product-list-api.service";
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";

describe('ProductListApiService', () => {
  let service: ProductListApiService;
  let httpTestingController: HttpTestingController;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProductListApiService],
    }).compileComponents()
    httpTestingController = TestBed.inject(HttpTestingController);
    service = TestBed.inject(ProductListApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return an Observable<BerthCraneFitAPIJson>', () => {
    const page = 1;
    const size = 15;
    service.getProducts(page, size).subscribe((response) => {
      expect(response).toEqual(response);
    });

    const req = httpTestingController.expectOne(
      `/products?page=${page}&size=${size}`
    );
    req.flush(
      [{
        id: 1,
        name: 'javascript cookbook',
        imageUrl: '',
        price: 56,
        stock: 134,
      },
        {
          id: 2,
          name: 'java cookbook',
          imageUrl: '',
          price: 53,
          stock: 123,
        },
        {
          id: 3,
          name: 'python cookbook',
          imageUrl: '',
          price: 54,
          stock: 14,
        }]
    );
  });

});
