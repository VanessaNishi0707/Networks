import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.io.FileWriter; 


public class TestDemo {

    User root;
    User next;

    public TestDemo() {
        root = null;
        next = null;
    }

    public class User {
        String name;
    
        public User(String name) {
            this.name = name;
        }
    }

    public void set(String s, String t) {
        root = new User(s);
        next = new User(t);
    }

    public void printRoot() {
        System.out.println(root.name);
    }

    public void writeDot(String filename) {
        try {
            PrintWriter output = new PrintWriter(new FileWriter(filename));

            output.println("digraph BST {");
            output.println("node [shape record]");

            if (root != null) {
                writeDotRecursive(root, next, output);
            }
            output.println("}");
            output.close();
        }
        catch(Exception e){e.printStackTrace();}
    }

    private void writeDotRecursive(User root, User next, PrintWriter output) throws Exception {
        output.println(root.name + " -> " + next.name);
    }
}
