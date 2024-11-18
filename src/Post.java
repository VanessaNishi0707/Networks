import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum Color {
    WHITE,
    GREY,
    BLACK
}

public class Post {
    String content;
    Date creationTime;
    List<View> views;
    List<Comment> comments;
    List<User> viewers; // list of users who have viewed
    User user; // author

    // used by SampleData
    public Color color;

    public Post(String content, Date creationTime, User user) {
        this.content = content;
        this.creationTime = creationTime;
        this.user = user;
        this.views = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.viewers = new ArrayList<>();

        color = Color.WHITE;
    }

    public void addView(View view) {
        views.add(view);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addViewer(User viewer) {
        viewers.add(viewer);
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

    public User getUser () {
        return user;
    }

    public String getContent() {
        return content;
    }
}