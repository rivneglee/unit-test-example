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
                String value = resolver.resolve(i);
                if (value != null) {
                    writer.write(value);
                    writer.write(",");
                    writer.flush();
                }
            } catch (IOException e) { }
        });
    }
}
