package Qu_2.Model;

import jakarta.persistence.*;

@MappedSuperclass
@Entity
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String title ;
    private String author;
    private int duration;
    @Embedded
    private Category category;
    @Enumerated(EnumType.STRING)
    private ContentStatus contentStatus;

    public Content( String title, String author, int duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    public Content() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

