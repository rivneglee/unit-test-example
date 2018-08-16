import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.Writer;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class IntRangePrinterTest {
    private IntRangePrinter printer;

    @Mock
    Writer outputStream;

    @Mock
    Resolver<Integer> resolver;

    @Before
    public void setUp() {
        printer = new IntRangePrinter(outputStream, resolver);
    }

    @Test
    public void withGivenRangePrinterShouldResolveAndOutputCorrect() throws IOException {
        when(resolver.resolve(1)).thenReturn("A");
        when(resolver.resolve(2)).thenReturn("B");
        when(resolver.resolve(3)).thenReturn("C");
        printer.print(1, 3);
        verify(outputStream).write("A");
        verify(outputStream).write("B");
        verify(outputStream).write("C");
    }

    @Test
    public void withGivenInvalidRangePrinterShouldDoNothing() throws IOException {
        printer.print(0, -1);
        verify(resolver, never()).resolve(anyInt());
        verify(outputStream, never()).write(anyString());
    }

    @Test
    public void withGivenSingleValueRangePrinterShouldResolveAndOutputOnce() throws IOException {
        when(resolver.resolve(0)).thenReturn("A");
        printer.print(0, 0);
        verify(outputStream).write("A");
    }

    @Test
    public void whenIOErrorOccurRangePrinterShouldNotBreakOutput() throws IOException {
        when(resolver.resolve(1)).thenReturn("A");
        when(resolver.resolve(2)).thenReturn("B");
        when(resolver.resolve(3)).thenReturn("C");
        doThrow(new IOException()).when(outputStream).write("B");
        printer.print(1, 3);
        verify(outputStream).write("A");
        verify(outputStream).write("C");
    }
}
