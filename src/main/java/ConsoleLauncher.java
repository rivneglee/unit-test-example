import java.io.OutputStreamWriter;
import java.io.Writer;

public class ConsoleLauncher {
    public static void main(String [] args) {
        Writer writer = new OutputStreamWriter(System.out);
        Resolver<Integer> resolver = new FizzBuzzResolver();
        RangePrinter<Integer> rangePrinter = new IntRangePrinter(writer, resolver);
        rangePrinter.print(1, 100);
    }
}
