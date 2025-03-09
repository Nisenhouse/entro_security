package org.example;

public class Content {
    private String download_url;
    private String type;

    public Content(String download_url, String type) {
        this.download_url = download_url;
        this.type = type;
    }

    public String getDownloadUrl() {
        return download_url;
    }

    public void setDownloadUrl(String download_url) {
        this.download_url = download_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
