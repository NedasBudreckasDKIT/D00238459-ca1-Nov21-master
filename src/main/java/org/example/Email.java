import java.util.Date;

public class Email {
    private String to;
    private String subject;
    private String text;
    private String date;

    public Email(String to, String subject, String text, String date) {
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

    public String getDate() {
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

    public void setDate(String date) {
        this.date = date;
    }

    public void sendEmail(){
        System.out.println("To: " + this.to);
        System.out.println("Subject: "+ this.subject);
        System.out.println("Text: "+ this.subject);
        System.out.println("Date: "+ this.date);
        System.out.println("Email Sent.");
    }

}