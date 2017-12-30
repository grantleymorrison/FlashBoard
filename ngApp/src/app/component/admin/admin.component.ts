import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin/admin.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  newUsers: Array<string>;
  promotees: Array<string>;

  public banUser;
  public suspendUser;
  public testId;
  public issue;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.getNewUsers();
    this.getPromotees();
  }

  public getNewUsers(){
    this.adminService.getNewUsers().subscribe(
      data => this.newUsers = data,
      err => console.log(err)
    );
  }

  public getPromotees(){
    this.adminService.getPromotees().subscribe(
      data => {
        this.promotees = data;
      },
      err => {
        console.log(err);
      }
    )
  }

  public blacklistUser(){
    this.adminService.blacklistUser(this.suspendUser);
  }

  public deleteUser(){
    this.adminService.deleteUser(this.banUser);
  }

  public deleteTest(){

  }

}
