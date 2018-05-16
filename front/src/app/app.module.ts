import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatToolbarModule,
  MatFormFieldModule,
  MatInputModule,
  MatIconModule,
  MatButtonModule,
  MatAutocompleteModule,
} from '@angular/material';
import 'hammerjs';

import { AngularSvgIconModule } from 'angular-svg-icon';
import { QuillModule } from 'ngx-quill';
import Quill from 'quill';

import { AppRoutingModule } from './app-routing.module';

import { PostsService } from './posts.service';
import { InMemoryDataService } from './in-memory-data.service';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { EditorComponent } from './editor/editor.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { MainComponent } from './main/main.component';
import { PostPageComponent } from './post-page/post-page.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';

window.Quill = Quill;

const ImageResize = require('quill-image-resize-module').default;

window.Quill.register('module/imageResize', ImageResize);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    EditorComponent,
    CreatePostComponent,
    MainComponent,
    PostPageComponent,
    SearchbarComponent,
    ProfilePageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    QuillModule,
    FormsModule,
    HttpClientModule,
    AngularSvgIconModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatAutocompleteModule,

    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { passThruUnknownUrl: true, dataEncapsulation: false }
    ),
  ],
  providers: [
    PostsService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
