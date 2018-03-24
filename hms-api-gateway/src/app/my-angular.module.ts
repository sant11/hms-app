// import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, 
    MatSortModule, MatButtonModule, MatCommonModule, MatCardModule, 
    MatIconModule,MatMenuModule,MatTabsModule} from '@angular/material';

@NgModule({
    imports: [
        MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, MatSortModule, 
        MatButtonModule,MatCommonModule,MatCardModule,MatIconModule,MatMenuModule,MatTabsModule

    ],
    exports: [
        MatTableModule, MatFormFieldModule, MatPaginatorModule, MatInputModule, MatSortModule, 
        MatButtonModule,MatCommonModule,MatCardModule,MatIconModule,MatMenuModule,MatTabsModule

    ]
  })
export class MyAngularMaterialModule { }