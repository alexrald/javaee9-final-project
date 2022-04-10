import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap, map} from "rxjs";
import {Post} from "../models/post";
import {BACKEND_CREATE_POST, BACKEND_NEWS_FEED} from "../constants/constant";

@Injectable({
  providedIn: 'root'
})
export class NewsFeedService {

  constructor(private http: HttpClient) { }

  getRecentPosts(): Observable<Array<Post>> {
    return this.http.get<any>(BACKEND_NEWS_FEED)
      .pipe(
        tap(value => console.log("Data before processing: " + JSON.stringify(value))),
        map((value: Array<any>) =>
          value.map(item =>
            <Post>{
              id: item.id,
              header: item.header,
              content: item.content,
              author: item.author,
              creationDateTime: item.creation_timestamp,
              updateDateTime: item.update_timestamp
            })),
        tap(value => console.log("Data after processing: " + JSON.stringify(value)))
      );
  }

  createNewPost(newPost: Post) {
    console.log(`Trying to send to backend new post: [${newPost}]`);
    this.http.post(BACKEND_CREATE_POST, newPost);

  }
}
