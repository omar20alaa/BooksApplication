package com.ahlyclub.omar2.booksapplication.Activity.Activity.Model;

import java.io.Serializable;

public class Books  implements Serializable{

    String image,
           title,
           subtitile,
           author,
           publishDate,
           descreption,
           publisher,
           category,
           language,
           country ,
           saleability;


    public Books(String image, String title, String subtitile, String author, String publishDate, String descreption, String publisher, String category, String language, String country, String saleability) {
        this.image = image;
        this.title = title;
        this.subtitile = subtitile;
        this.author = author;
        this.publishDate = publishDate;
        this.descreption = descreption;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.country = country;
        this.saleability = saleability;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitile() {
        return subtitile;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getDescreption() {
        return descreption;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getSaleability() {
        return saleability;
    }

}
