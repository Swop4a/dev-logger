import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap, map, mergeMap } from 'rxjs/operators';
import { Store, select, Action } from '@ngrx/store';
import { Effect, ofType, Actions } from '@ngrx/effects';

import { AppState } from './store/rootReducer';
import {
  TOGGLE_POSTS,
  GET_POSTS,
  GET_POSTS_COMPLETED,
  GET_POSTS_FAILED,
  TOGGLE_SMART_POSTS,
  State as PostsState,
  GetPostsAction,
  GetPostsCompletedAction,
} from './store/posts';

import { SearchPost } from './search-post';

import { POSTS_SERVICE_URL } from './consts';

@Injectable()
export class PostsService {
  private getPostsURL = `${POSTS_SERVICE_URL}/getPosts`;
  private getPostURL = `${POSTS_SERVICE_URL}/getPost`;

  private postsInfo: PostsState;

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private store: Store<AppState>,
    private actions$: Actions,
  ) {
    this.store.select<PostsState>('posts').subscribe(
      postsInfo => this.postsInfo = postsInfo,
    );
  }

  @Effect()
  posts$: Observable<GetPostsCompletedAction> = this.actions$.pipe(
    ofType(GET_POSTS),
    mergeMap((action: GetPostsAction) =>
      this.http.get(
        `${this.getPostsURL}?tab=${action.payload.postsType}&smart=${action.payload.isSmart}`,
        this.httpOptions,
      ).pipe(
        map((data: SearchPost[]) => ({ type: GET_POSTS_COMPLETED, payload: data })),
        catchError(() => of({ type: GET_POSTS_FAILED })),
      ),
    ),
  );

  // getPosts(): Observable<SearchPost[]> {
  //   return this.http.get<SearchPost[]>(`${this.getPostsURL}?tab=${this.postsInfo.postsType}&smart=${this.postsInfo.isSmart}`)
  //     .pipe(
  //       tap(heroes => this.log('posts fetched')),
  //       catchError(this.handleError('getPosts', [])),
  //     );
  // }

  getPost(id: string): Observable<SearchPost> {
    return this.http.get<SearchPost>(`${this.getPostURL}/${id}`)
      .pipe(
        tap(_ => this.log(`fetched post with id=${id}`)),
        catchError(this.handleError<SearchPost>('getPost')),
      );
  }

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

  searchPosts(term: string): Observable<SearchPost[]> {
    if (!term.trim()) {
      return of([]);
    }

    return this.http.get<SearchPost[]>(`${this.getPostsURL}/?title=${term}`).pipe(
      tap(_ => this.log(`found posts matching "${term}"`)),
      catchError(this.handleError<SearchPost[]>('searchPosts', []))
    );
  }

  private log(message: string) {
    console.log(message);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result);
    };
  }

}
