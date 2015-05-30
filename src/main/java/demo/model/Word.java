package demo.model;

import java.io.Serializable;

public class Word implements Serializable {

    private Integer id;
    private String english;
    private String chinese;
    private String property;
    private String sentence;

    public Word() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getEnglish() {
        return this.english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String  getChinese() {
        return this.chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String  getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String  getSentence() {
        return this.sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}