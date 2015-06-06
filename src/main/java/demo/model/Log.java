package demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date logdate;
    private String content;
    private int userId;

    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date  getLogdate() {
        return this.logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public String  getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int  getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}