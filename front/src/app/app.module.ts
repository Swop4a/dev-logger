import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { QuillModule } from 'ngx-quill';

import { AppComponent } from './app.component';

import Quill from 'quill';

window.Quill = Quill;

const ImageResize = require('quill-image-resize-module').default;

window.Quill.register('module/imageResize', ImageResize);

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    QuillModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
