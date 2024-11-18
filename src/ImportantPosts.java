import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.io.FileWriter; 
import java.io.*;
import java.util.*;

public class ImportantPosts {

    User user1;
    User user2;

    public ImportantPosts() {
    }


    public void set() {
        user1 = new User("user1", 20, "F", "NA");
        user2 = new User("user2", 15, "M", "ASIA");
    }

    public void printRoot() {
    }

    /*public void writeDot(String filename) {
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
    }*/

    public static void main(String[] args) throws Exception {
        ImportantPosts test = new ImportantPosts();
        SampleData data = new SampleData();
    
        test.set();
    }
}

