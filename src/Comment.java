import java.util.Date;

public class Comment {
    User user;
    String content;
    Date commentTime;

    public Comment(User user, String content, Date commentTime) {
        this.user = user;
        this.content = content;
        this.commentTime = commentTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public User getUser () {
        return user;
    }

    public String getContent() {
        return content;
    }
}