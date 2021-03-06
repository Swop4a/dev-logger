import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap, map, mergeMap, withLatestFrom } from 'rxjs/operators';
import { Effect, ofType, Actions } from '@ngrx/effects';

import { Store } from '@ngrx/store';

import { AppState } from './reducers/rootReducer';
import {
  GET_POSTS,
  GET_POSTS_COMPLETED,
  GET_POSTS_FAILED,

  GET_POST,
  GET_POST_COMPLETED,
  GET_POST_FAILED,

  GET_USER_POSTS,
  GET_USER_POSTS_SUCCESS,
  GET_USER_POSTS_FAILURE,

  GetPostsAction,
  GetPostsCompletedAction,

  GetPostAction,
  GetPostCompletedAction,

  GetUserPostsSuccessAction,
} from './reducers/posts';

import { SearchPost } from './search-post';

import { POSTS_SERVICE_URL } from './consts';

@Injectable()
export class PostsService {
  private getPostsURL = `${POSTS_SERVICE_URL}`;
  private getPostURL = `${POSTS_SERVICE_URL}`;

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private actions$: Actions,
    private store: Store<AppState>,
  ) {}

  // NOTE: Main version
  // @Effect()
  // getPosts$: Observable<GetPostsCompletedAction> = this.actions$.pipe(
  //   ofType(GET_POSTS),
  //   mergeMap(({ payload }: GetPostsAction) => {
  //     return this.getPosts(payload).pipe(
  //       map((posts: SearchPost[]) => ({ type: GET_POSTS_COMPLETED, payload: posts })),
  //       catchError(() => of({ type: GET_POSTS_FAILED })),
  //     );
  //   }),
  // );

  @Effect()
  getPosts$: Observable<GetPostsCompletedAction> = this.actions$.pipe(
    ofType(GET_POSTS),
    withLatestFrom(this.store),
    mergeMap(([{ payload }, storeState]: [GetPostsAction, AppState]) => {
      return this.getPosts({
        ...payload,
        username: storeState.account.user
          ? storeState.account.user.handle
          : null,
      }).pipe(
        map((posts: SearchPost[]) => ({ type: GET_POSTS_COMPLETED, payload: posts })),
        catchError(() => of({ type: GET_POSTS_FAILED })),
      );
    }),
  );

  @Effect()
  getPost$: Observable<GetPostCompletedAction> = this.actions$.pipe(
    ofType(GET_POST),
    mergeMap((action: GetPostAction) =>
      this.http.get(`${this.getPostsURL}/${action.payload.id}`).pipe(
        map((data: SearchPost) => ({ type: GET_POST_COMPLETED, payload: data })),
        catchError(() => of({ type: GET_POST_FAILED })),
      )
    ),
  );

  // NOTE: will be used somewhen
  // @Effect()
  // getUserPosts$: Observable<GetUserPostsSuccessAction> = this.actions$.pipe(
  //   ofType(GET_USER_POSTS),
  //   mergeMap(() => {
  //     const headers = new HttpHeaders({
  //       Authorization: `Bearer ${localStorage.getItem('token')}`,
  //     });
  //
  //     return this.getPosts({ postsType: 2, isSmart: null }, headers).pipe(
  //       map((posts: SearchPost[]) => ({ type: GET_USER_POSTS_SUCCESS, payload: posts })),
  //       catchError(() => of({ type: GET_USER_POSTS_SUCCESS })),
  //     );
  //   }),
  // );

  @Effect()
  getUserPosts$: Observable<GetUserPostsSuccessAction> = this.actions$.pipe(
    ofType(GET_USER_POSTS),
    withLatestFrom(this.store),
    mergeMap(([_, storeState]) =>
      this.getPosts({
        postsType: 2,
        isSmart: false,
        username: storeState.account.user.handle,
      }).pipe(
        map((posts: SearchPost[]) => ({ type: GET_USER_POSTS_SUCCESS, payload: posts })),
        catchError(() => of({ type: GET_USER_POSTS_SUCCESS })),
      )),
  );


  private getPosts(payload, headers?: HttpHeaders) {
    return this.http.get(
      `${this.getPostsURL}/?handle=${payload.username || null}&tab=${payload.postsType}&smart=${payload.isSmart}`,
      { headers },
    );
  }

  // NOTE: main function, will be used somewhen
  // private getPosts(payload, headers?: HttpHeaders) {
  //   return this.http.get(
  //     `${this.getPostsURL}/?handle=PProgrammer&tab=${payload.postsType}&smart=${payload.isSmart}`,
  //     { headers },
  //   );
  // }

  // updateHero(hero: SearchPost): Observable<any> {
  //   return this.http.put(`${this.getPostsURL}/${hero.id}`, hero, this.httpOptions)
  //     .pipe(
  //       tap(_ => this.log(`updated hero with id=${hero.id}`)),
  //       catchError(this.handleError('updateHero')),
  //     );
  // }

  // addHero(hero: SearchPost): Observable<SearchPost> {
  //   return this.http.post<SearchPost>(this.getPostsURL, hero)
  //     .pipe(
  //       tap(_hero => this.log(`added hero id=${_hero.id}`)),
  //       catchError(this.handleError<SearchPost>('addHero')),
  //     );
  // }

  // deleteHero(hero: SearchPost): Observable<any> {
  //   return this.http.delete<SearchPost>(`${this.getPostsURL}/${hero.id}`)
  //     .pipe(
  //       tap(_ => this.log(`deleted hero id=${hero.id}`)),
  //       catchError(this.handleError<SearchPost>('deleteHero')),
  //     );
  // }

  // TODO: rework
  // searchPosts(term: string): Observable<SearchPost[]> {
  //   if (!term.trim()) {
  //     return of([]);
  //   }
  //
  //   return this.http.get<SearchPost[]>(`${this.getPostsURL}/?title=${term}`).pipe(
  //     // tap(_ => this.log(`found posts matching "${term}"`)),
  //     catchError(this.handleError<SearchPost[]>('searchPosts', []))
  //   );
  // }

  // /**
  //  * Handle Http operation that failed.
  //  * Let the app continue.
  //  * @param operation - name of the operation that failed
  //  * @param result - optional value to return as the observable result
  //  */
  // private handleError<T> (operation = 'operation', result?: T) {
  //   return (error: any): Observable<T> => {
  //
  //     // TODO: send the error to remote logging infrastructure
  //     console.error(error); // log to console instead
  //
  //     // TODO: better job of transforming error for user consumption
  //     // this.log(`${operation} failed: ${error.message}`);
  //
  //     // Let the app keep running by returning an empty result.
  //     return of(result);
  //   };
  // }
  //
}
