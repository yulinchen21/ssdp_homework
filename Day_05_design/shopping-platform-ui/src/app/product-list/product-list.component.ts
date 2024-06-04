import {Component, OnInit} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable
} from "@angular/material/table";
import {Product} from "../../interface/Product";
import {ProductListService} from "../../service/product-list.service";

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [
    MatTable,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatHeaderRow,
    MatRow,
    MatHeaderCellDef,
    MatCellDef,
    MatHeaderRowDef,
    MatRowDef
  ],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.scss'
})
export class ProductListComponent implements OnInit {
  dataSource: Product[] = [];
  displayedColumns = ['id', 'name', 'price', 'stock'];

  constructor(private productListService: ProductListService) {}

  ngOnInit(): void {
    this.productListService.getProducts(1,15).subscribe(res => this.dataSource = res);
  }
}
