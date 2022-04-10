import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent implements OnInit {

  postForm = this.formBuilder.group({
    header:   ['', Validators.required],
    content:  ['', Validators.required],
    author:   ['', Validators.required]
  });

  constructor(private formBuilder: FormBuilder) {  }

  ngOnInit(): void {
  }

  // TODO:
  // 1) Service - for sending news to backend
  // 2)New form for news
  // 2.a) all required fields
  // 2.b) validation on those fields
  // 2.c) gather fields and push them

  createPost() {
    console.log("Trying to create post");
  }
}
