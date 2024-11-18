import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class ImportantPosts {
    private Map<User, List<Post>> adjList;

    public List<User> allUsers; 
    public List<Post> allPosts;

    ImportantPosts() {
        adjList = new HashMap<User, List<Post>>();
        allUsers = new ArrayList<>();
        allPosts = new ArrayList<>();
    }

    public void addUser(User user) {
        adjList.put(user, new ArrayList<>());
        allUsers.add(user);
    }

    public void addPost(User author, Post post) {
        adjList.get(author).add(post);
        allPosts.add(post);
        author.postsCreated.add(post);
    }

    public void addEdge(User start, Post destination) {
        Edge edge = new Edge(start, destination);
        adjList.get(start).add(destination);
    }

    public void createData(ImportantPosts data) {
        User user1 = new User("user1", 0, null, null);
        addUser(user1);
        User user2 = new User("user2", 0, null, null);
        addUser(user2);
        Post post1 = new Post("post1", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago
        Post post2 = new Post("post2", new Date(System.currentTimeMillis() - 1000000000), user2); // Created 1 day ago
        Post post3 = new Post("post3", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago
        Post post4 = new Post("post4", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago

        addPost(user1, post1);
        addPost(user1, post2);
        addPost(user1, post3);
        addPost(user1, post4);
        
        addPost(user2, post1);
        addPost(user2, post2);
        addPost(user2, post3);
        addPost(user2, post4);
    }

    public void print() {
        for (Map.Entry<User, List<Post>> entry : adjList.entrySet()) {
            if (entry.getKey().color == Color.WHITE) {
                entry.getKey().color = Color.GREY;
                System.out.println(entry.getKey().username);

                for (Post element : entry.getValue()) {
                    if (element.color == Color.WHITE) {
                        element.color = Color.GREY;
                        System.out.println(element.content);
                    }
                }
            }
        }   
    }

    public void createGraph(String filename) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));

            output.println("digraph BST {");

            for (Map.Entry<User, List<Post>> entry : adjList.entrySet()) {
                for (Post element : entry.getValue()) {
                    output.print(entry.getKey().username + " -> ");
                    if (element.user == entry.getKey()) {
                        output.println(element.content);
                        output.println(element.content + "[shape=square]");
                    }
                    else {
                        output.println(element.content + "[dir=none]");
                        output.println(element.content + "[shape=square]");

                    }
                    /*if (element.color == Color.WHITE) {
                        element.color = Color.GREY;
                        System.out.println(element.content);
                    }*/
                }
            }

            output.println("}");
            output.close();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) throws Exception {
        ImportantPosts data = new ImportantPosts();
        
        data.createData(data);
        data.createGraph("test");
    }
}
