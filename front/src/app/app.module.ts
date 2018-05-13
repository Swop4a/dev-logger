import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material';

import { AngularSvgIconModule } from 'angular-svg-icon';
import { QuillModule } from 'ngx-quill';
import Quill from 'quill';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { EditorComponent } from './editor/editor.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { MainComponent } from './main/main.component';
import { PostPageComponent } from './post-page/post-page.component';

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
    PostPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    QuillModule,
    FormsModule,
    HttpClientModule,
    AngularSvgIconModule,
    BrowserAnimationsModule,
    MatToolbarModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
