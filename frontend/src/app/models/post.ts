export interface Post {
  id:               number,
  header:           string,
  content:          string,
  author:           string,
  creationDateTime: string|null,   // TODO: Change for date server
  updateDateTime:   string|null;
}
