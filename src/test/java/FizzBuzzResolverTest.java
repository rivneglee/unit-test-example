import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzResolverTest {
    private FizzBuzzResolver resolver;

    @Before
    public void setup() {
        resolver = new FizzBuzzResolver();
    }

    @Test
    public void whenGivenNumberIsMultiplesOf3ResolverShouldPrintFizz() {
        Assert.assertEquals("Fizz", resolver.resolve(3));
    }

    @Test
    public void whenGivenNumberIsMultiplesOf5ResolverShouldPrintBuzz() {
        Assert.assertEquals("Buzz", resolver.resolve(10));
    }

    @Test
    public void whenGivenNumberIsMultiplesOf3And5ResolverShouldPrintFizzBuzz() {
        Assert.assertEquals("FizzBuzz", resolver.resolve(30));
    }

    @Test
    public void whenGivenNumberIsNotMultiplesOf3And5ResolverShouldConvertNumberToString() {
        Assert.assertEquals("7", resolver.resolve(7));
    }
}
