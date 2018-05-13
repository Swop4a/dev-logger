import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AngularSvgIconModule } from 'angular-svg-icon';

import { AppRoutingModule } from './app-routing.module';
import { QuillModule } from 'ngx-quill';

import { AppComponent } from './app.component';

import Quill from 'quill';
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
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
