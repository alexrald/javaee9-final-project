import { Component, OnInit } from '@angular/core';
import {Post} from "../../models/post";
import {NewsFeedService} from "../../services/news-feed.service";

@Component({
  selector: 'app-news-feed',
  templateUrl: './news-feed.component.html',
  styleUrls: ['./news-feed.component.css']
})
export class NewsFeedComponent  implements OnInit {

  news: Array<Post> = [];

  constructor(private newsFeedService: NewsFeedService) { }

  ngOnInit(): void {
    this.newsFeedService
      .getRecentPosts()
      .subscribe(
        // Inside subscribe method we are directly in Observable,
        // so we've got access to Array<Post>
        value =>
          this.news = value
        );

  }

}
