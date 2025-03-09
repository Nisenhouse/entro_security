package org.example;

public class CommitInfo {
    private String url;
    private String author;

    public CommitInfo(String url, String author) {
        this.url = url;
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
