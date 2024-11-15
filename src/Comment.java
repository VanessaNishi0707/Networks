import java.util.Date;

public class Comment {
    String user;
    String content;
    Date commentTime;

    public Comment(String user, String content, Date commentTime) {
        this.user = user;
        this.content = content;
        this.commentTime = commentTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }
}