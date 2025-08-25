package Qu_2.Model;

import jakarta.persistence.Entity;

@Entity

public class Tutorial extends  Content {


    private  String  topic;
    private boolean isFree;

    public Tutorial( String title, String author, int duration, String topic, boolean isFree) {
        super( title, author, duration);
        this.topic = topic;
        this.isFree = isFree;
    }

    public Tutorial() {
        super();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
