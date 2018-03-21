// import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, 
    MatSortModule, MatButtonModule} from '@angular/material';

@NgModule({
    imports: [
        MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, MatSortModule, MatButtonModule

    ],
    exports: [
        MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, MatSortModule, MatButtonModule

    ]
  })
export class MyAngularMaterialModule { }