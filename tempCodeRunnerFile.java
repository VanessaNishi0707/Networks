import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import static guru.nidi.graphviz.model.Factory.*;

public class Networks {
       public static void main(String[] args) {
           MutableGraph g = mutGraph("example1").directed()
                   .add(node("a").link(node("b")));
           Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("example1.png"));
       }
}