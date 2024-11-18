import java.util.*;

// Used by SampleData class
public class Edge {
    public Object source;
    public Object destination;
    public String type; // author to post OR post to viewer 

    Edge(Object source, Object destination) {
        this.source = source;
        this.destination = destination;

        if (source instanceof User) { 
            type = "AuthorToPost";
        }
        else if (source instanceof Post) {
            type = "PostToViewer";
        }
    }
}
