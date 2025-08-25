package Qu_2.Model;

import jakarta.persistence.Entity;

@Entity
public class Course extends  Content{


    private String level;
    private  int price;

    public Course( String title, String author, int duration, String level, int price) {
        super( title, author, duration);
        this.level = level;
        this.price = price;
    }

    public Course() {
        super();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
