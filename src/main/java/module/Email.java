package module;

public class Email {
    private final String name;
    private final String emailFrom;
    private final String message;
    public Email(String name, String emailFrom, String message) {
        this.name = name;
        this.emailFrom = emailFrom;
        this.message = message;
    }
    public String createBody() {
        return "Name : "+this.name+" Email : "+this.emailFrom;
    }
    public String createSubject() {
        return this.message;
    }
}
