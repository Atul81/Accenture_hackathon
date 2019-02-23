import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppService } from '../app.services';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from "rxjs/operators"
import { State, process } from '@progress/kendo-data-query';
import { GridDataResult, DataStateChangeEvent } from '@progress/kendo-angular-grid';

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  greeting: any = [];
  getId: string = '';
  categories: string[] = ['April', 'May', 'June', 'July', 'August', 'Sept'];
  series = [
    {
      name: "Billable Amount",
      data: [],
      desc: []
    },
    {
      name: "Due Amount",
      data: [],
      desc: []
    }];

  gridStateData = [];

  public state: State = {
    skip: 0,
    filter: {
      logic: 'and',
      filters: []
    }
  };

  public gridData: GridDataResult;
  constructor(private app: AppService, private http: HttpClient, private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.getId = params.get("id")
    })
    this.fetchDetails(this.getId);
  }

  public fetchDetails(custId: string) {
    this.app.findCustomerDetails(custId).subscribe((data: {}) => {
      this.greeting = data;
      this.greeting = this.greeting.responseBody;
      console.log(this.greeting);
      this.loadGraphData();
    });
  }

  public loadGraphData() {
    let getBillableAmount = [this.greeting.billAmt1, this.greeting.billAmt2, this.greeting.billAmt3, this.greeting.billAmt4, this.greeting.billAmt5, this.greeting.billAmt6];
    let getPayableAmount = [this.greeting.payAmt1, this.greeting.payAmt2, this.greeting.payAmt3, this.greeting.payAmt4, this.greeting.payAmt5, this.greeting.payAmt6];
    let getPaymentStatus = [this.greeting.pay0, this.greeting.pay2, this.greeting.pay3, this.greeting.pay4, this.greeting.pay5, this.greeting.pay6];
    this.series[0].data = getBillableAmount;
    this.series[0].desc = getPaymentStatus;
    this.series[1].desc = getPaymentStatus;
    this.series[1].data = getPayableAmount;
    for (let i of Object.keys(getBillableAmount)) {
      this.gridStateData.push({
        'billAmt': getBillableAmount[i],
        'payAmt': getPayableAmount[i],
        'name': getPaymentStatus[i]
      })
    }
    this.gridData = process(this.gridStateData, this.state);
  }


  public dataStateChange(state: DataStateChangeEvent): void {
    this.state = state;
    this.gridData = process(this.gridStateData, this.state);
  }

}
