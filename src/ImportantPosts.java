import java.io.*;
import java.util.*;

public class ImportantPosts {
    private Map<User, List<Post>> adjList;

    ImportantPosts() {
        adjList = new HashMap<User, List<Post>>(); // maps user -> posts they've either created or viewed
    }

    public void addUser(User user) {
        adjList.put(user, new ArrayList<>());
    }

    public void addPost(User author, Post post) {
        adjList.get(author).add(post);
    }

    public void createData() {
        User user1 = new User("user1", 0, null, null);
        User user2 = new User("user2", 0, null, null);
        addUser(user1);
        addUser(user2);

        Post post1 = new Post("post1", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago
        Post post2 = new Post("post2", new Date(System.currentTimeMillis() - 1000000000), user2); // Created 1 day ago
        Post post3 = new Post("post3", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago
        Post post4 = new Post("post4", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago

        addPost(user1, post1); // does not differentiate between authorship or viewership of posts 
        addPost(user1, post2);
        addPost(user1, post3);
        addPost(user1, post4);
        addPost(user2, post1);
        addPost(user2, post2);
        addPost(user2, post3);
        addPost(user2, post4);

        post1.addView(new View(new Date(System.currentTimeMillis() - 100000000))); 
        post2.addView(new View(new Date(System.currentTimeMillis() - 200000000))); 
        post2.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post3.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post3.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post3.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post4.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post4.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post4.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 
        post4.addView(new View(new Date(System.currentTimeMillis() - 30000000))); 

        post1.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post2.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post2.addComment(new Comment(user2, "Very informative!", new Date(System.currentTimeMillis() - 10000000)));
        post3.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post3.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post3.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post4.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post4.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post4.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post4.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));

        System.out.println("post1 num views: " + post1.views.size()); // 1
        System.out.println("post2 num views: " + post2.views.size()); // 2
        System.out.println("post3 num views: " + post3.views.size()); // 3
        System.out.println("post4 num views: " + post4.views.size()); // 4

        System.out.println("post1 num comments: " + post1.comments.size()); // 1
        System.out.println("post2 num comments: " + post2.comments.size()); // 2
        System.out.println("post3 num comments: " + post3.comments.size()); // 3
        System.out.println("post4 num comments: " + post4.comments.size()); // 4

        System.out.println("The GraphViz files have been created!");
    }

    // Iterates through users & the posts they either create or view and converts data into GraphViz syntaz that is read into a file
    // COPY FILE INTO THIS WEBSITE http://www.jdolivet.byethost13.com/Logiciels/WebGraphviz/ to view graph representation, 
    // Pictures of this particular graph will be attached to assignment submission

    // SYMBOLS: 
    // Circle shape: user, square shape: post, directed edge: connects author->post, undir edge: connects viewer-post
    // Red: Number of comments higher than some num; blue: number of views higher than some num
    public void createGraph(String filename, String sortBy, int num) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));

            output.println("digraph BST {");

            for (Map.Entry<User, List<Post>> entry : adjList.entrySet()) {
                for (Post element : entry.getValue()) {
                    output.print(entry.getKey().username + " -> ");
                    if (element.user == entry.getKey()) {
                        if ((sortBy == "numView") && (element.views.size() >= num)) {
                            output.println(element.content);
                            output.println(element.content + "[shape=square, color=blue]");
                        }
                        else if ((sortBy == "numComment") && (element.comments.size() >= num)) {
                            output.println(element.content);
                            output.println(element.content + "[shape=square, color=red]");
                        }
                        else {
                            output.println(element.content);
                            output.println(element.content + "[shape=square]");
                        }
                    }
                    else {
                        if ((sortBy == "numView") && (element.views.size() >= num)) {
                            output.println(element.content + "[dir=none]");
                            output.println(element.content + "[shape=square, color=blue]");
                        }
                        else if ((sortBy == "numComment") && (element.comments.size() >= num)) {
                            output.println(element.content + "[dir=none]");
                            output.println(element.content + "[shape=square, color=red]");
                        }
                        else {
                            output.println(element.content + "[dir=none]");
                            output.println(element.content + "[shape=square]");
                        }
                    }
                }
            }

            output.println("}");
            output.close();
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    public void graphHighlightByViews(String filename, int numViews) {
        createGraph(filename, "numView", numViews); 
    }

    public void graphHighlightByComments(String filename, int numComments) {
        createGraph(filename, "numComment", numComments); 
    }

    public static void main(String[] args) throws Exception {
        ImportantPosts data = new ImportantPosts();
        
        data.createData();
        data.createGraph("plainGraph", null, 0);
        data.graphHighlightByViews("graphWithView>=2",2);
        data.graphHighlightByComments("graphWishComment>=4", 4);
    }
}
