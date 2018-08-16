public class FizzBuzzResolver implements Resolver<Integer> {
    @Override
    public String resolve(Integer value) {
        if (value == null) return null;
        if (value == 0) return value.toString();
        if (value % 15 == 0) {
            return "FizzBuzz";
        } else if (value % 5 == 0) {
            return "Buzz";
        } else if (value % 3 == 0) {
            return "Fizz";
        }
        return value.toString();
    }
}
