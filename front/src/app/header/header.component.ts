import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Store } from '@ngrx/store';

import {
  State as AccountState,
} from '../reducers/account.reducer';
import { AppState } from '../reducers/rootReducer';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;

  constructor(
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.store.select<AccountState>('account').subscribe(
      accountData => this.isLoggedIn = accountData.isLoggedIn,
    );
  }

}
