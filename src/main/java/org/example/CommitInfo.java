package org.example;

public class CommitInfo {
    private String url;
    private Author author;

    public CommitInfo(String url, Author author) {
        this.url = url;
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public class Author {
        private String login;

        public Author(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }
}
