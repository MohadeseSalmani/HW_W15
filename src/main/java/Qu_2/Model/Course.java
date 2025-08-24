package Qu_2.Model;

import jakarta.persistence.Entity;

@Entity
public class Course extends  Content{


    private int level;
    private  int price;

    public Course(int id, String title, String author, int duration, int level, int price) {
        super(id, title, author, duration);
        this.level = level;
        this.price = price;
    }

    public Course() {
        super();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
