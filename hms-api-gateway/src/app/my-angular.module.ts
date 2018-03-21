// import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, 
    MatSortModule, MatButtonModule, MatCommonModule, MatCardModule, 
    MatIconModule,MatMenuModule} from '@angular/material';

@NgModule({
    imports: [
        MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, MatSortModule, 
        MatButtonModule,MatCommonModule,MatCardModule,MatIconModule,MatMenuModule

    ],
    exports: [
        MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, MatSortModule, 
        MatButtonModule,MatCommonModule,MatCardModule,MatIconModule,MatMenuModule

    ]
  })
export class MyAngularMaterialModule { }