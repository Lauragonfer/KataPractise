import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzShould {

    @Test
    public void test(){
        FizzBuzzApp fizzBuzzApp = new FizzBuzzApp(4);
        String numbersExpected = "12Fizz4";
        assertEquals(numbersExpected,fizzBuzzApp.createdListNumbers());
    }

}
