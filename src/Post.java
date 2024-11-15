import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    String content;
    Date creationTime;
    List<View> views;
    List<Comment> comments;

    public Post(String content, Date creationTime) {
        this.content = content;
        this.creationTime = creationTime;
        this.views = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addView(View view) {
        views.add(view);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public long getViewCount() {
        return views.size();
    }

    public long getCommentCount() {
        return comments.size();
    }

    public Date getCreationTime() {
        return creationTime;
    }
}