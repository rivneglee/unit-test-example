import java.io.IOException;
import java.io.Writer;
import java.util.stream.IntStream;

public class IntRangePrinter implements RangePrinter<Integer> {

    private Writer writer;

    private Resolver<Integer> resolver;

    public IntRangePrinter(Writer outputStream, Resolver<Integer> resolver) {
        this.resolver = resolver;
        this.writer = outputStream;
    }

    @Override
    public void print(Integer from, Integer to) {
        IntStream.rangeClosed(from, to).forEach(i -> {
            try {
                writer.write(resolver.resolve(i));
                writer.write(",");
                writer.flush();
            } catch (IOException e) { }
        });
    }
}
