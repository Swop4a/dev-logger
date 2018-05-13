import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CreatePostComponent } from './create-post/create-post.component';
import { PostPageComponent } from './post-page/post-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'create', component: CreatePostComponent },
  { path: 'posts/:id', component: PostPageComponent },
  { path: 'profile', component: ProfilePageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
