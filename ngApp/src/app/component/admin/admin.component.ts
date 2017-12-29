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

  public banUser;
  public suspendUser;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.getNewUsers();
  }

  public getNewUsers(){
    this.adminService.getNewUsers().subscribe(
      data => this.newUsers = data,
      err => console.log(err)
    );
  }

  public blacklistUser(){
    this.adminService.blacklistUser(this.suspendUser);
  }

}
