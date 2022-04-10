import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {NewsFeedService} from "../../services/news-feed.service";
import {Post} from "../../models/post";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent {

  postForm = this.formBuilder.group({
    header:   ['', Validators.required],
    content:  ['', [Validators.required, Validators.min(3)]],
    author:   ['', [Validators.required, Validators.min(3)]]
  });

  constructor(private formBuilder: FormBuilder,
              private newsService: NewsFeedService) {  }


  // TODO:
  // 1) Service - for sending news to backend
  // 2)New form for news
  // 2.a) all required fields
  // 2.b) validation on those fields
  // 2.c) gather fields and push them

  onClick_formSubmit() {
    console.log(`Form submitted with the object: [${JSON.stringify(this.postForm.value)}`);

    let post: Post = {
      id:       0,
      author:   this.postForm.value.author,
      content:  this.postForm.value.content,
      header:   this.postForm.value.header,
      creationDateTime: null,
      updateDateTime: null
    }

    this.newsService.createNewPost(post);

  }
}
