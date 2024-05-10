import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Menu } from 'src/app/classes/menu';
import { MenuService } from 'src/app/services/menu.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{
  user:any;
  imageSource:any = [];
  allItems:any=[];
  i : any = 0;
  public constructor(private menuService:MenuService,private router:Router,private sanitizer:DomSanitizer){
  }

  ngOnInit(): void {
   this.user = JSON.parse(localStorage.getItem("loginData") || "[]");
  this.getAllItems();
  }

  public getAllItems() {
    this.menuService.getAllItem().subscribe((data: any) => {
      this.allItems = data;
      for (var i = 0; i < this.allItems.length; i++) {
        this.imageSource[i] =this.sanitizer.bypassSecurityTrustResourceUrl(`data:image/png;base64, ${this.allItems[i].image}`);    
  }     
     // console.log(this.imageSource);
     i++;
    },
      (error) => {
          Swal.fire('Failed !!', error.error.msg, 'error');
          console.log(error.error);
      })
  }
}
