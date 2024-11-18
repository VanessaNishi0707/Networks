import java.util.*;

public class SampleData {
    private Map<User, List<Post>> adjList;

    public List<User> allUsers; 
    public List<Post> allPosts;

    SampleData() {
        adjList = new HashMap<User, List<Post>>();
        allUsers = new ArrayList<>();
        allPosts = new ArrayList<>();
    }

    public void addUser(String username, int age, String gender, String region) {
        User user = new User(username, age, gender, region);
        adjList.put(user, new ArrayList<>());
        allUsers.add(user);
    }

    public void addEdge(User start, Post destination) {
        Edge edge = new Edge(start, destination);
        adjList.get(start).add(destination);
    }

    public void print() {
        for (Map.Entry<User, List<Post>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey().username);
            System.out.println(entry.getValue().get(0).content);
        }   
    }

    public void addPost(User author, String content, Date timeCreated) {
        Post post = new Post(content, timeCreated, author);
        allPosts.add(post);
        author.postsCreated.add(post);
    }
}
