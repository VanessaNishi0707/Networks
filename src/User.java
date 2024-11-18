import java.util.*;

enum Color {
    WHITE,
    GREY,
    BLACK
}

public class User {
    String username;
    int age;
    String gender;
    String region;
    Map<String, List<User>> connections; // string is category (follows, friends,..)
    List<Post> postsCreated;
    List<Post> postsViewed;
    List<Comment> comments;

    // used by SampleData
    public Color color;

    public User(String username, int age, String gender, String region) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.region = region;

        this.connections = new HashMap<String, List<User>>();
        this.connections.put("follows", new ArrayList<User>());
        this.connections.put("followers", new ArrayList<User>());
        this.connections.put("mutuals", new ArrayList<User>());
        this.connections.put("blocked", new ArrayList<User>());

        this.postsCreated = new ArrayList<>();
        this.postsViewed = new ArrayList<>();
        this.comments = new ArrayList<>();

        color = Color.WHITE;
    }


    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }
}