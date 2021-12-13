package org.example.src;

import java.time.LocalDateTime;

public class Email {
    private String to;
    private String subject;
    private String text;
    private LocalDateTime date;

    public Email(String to, String subject, String text, LocalDateTime date) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void sendEmail(){
        System.out.println("To: " + this.to);
        System.out.println("Subject: "+ this.subject);
        System.out.println("Text: "+ this.subject);
        String date = this.date.format(Main.format);
        System.out.println("Date: " + date);
        System.out.println("Email Sent.");
    }

}