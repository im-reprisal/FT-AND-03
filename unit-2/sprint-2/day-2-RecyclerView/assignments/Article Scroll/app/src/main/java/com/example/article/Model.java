package com.example.article;

public class Model {
       private int pic;
       private String title;
       private String article;
       private String author;

    public Model(int pic, String title, String article, String author) {
        this.pic = pic;
        this.title = title;
        this.article = article;
        this.author = author;
    }

    public int getPic() {
        return pic;
    }

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public String getAuthor() {
        return author;
    }
}
