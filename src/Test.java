public class Test {
    public static void main(String[] args) throws Exception {
        TestDemo test = new TestDemo();

        test.set("Hello-World", "Goodbye-World");
        test.printRoot();

        test.writeDot("testDot");
    }
}
