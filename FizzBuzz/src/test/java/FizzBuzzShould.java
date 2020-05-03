
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzShould {

    @Test
    public void addFizzToNumberListWhenNumberIsMultipleOfThree(){
        FizzBuzzApp fizzBuzzApp = new FizzBuzzApp(4);
        List<String> numbersExpected = new ArrayList<String>(Arrays.asList("1", "2", "Fizz", "4"));
        assertEquals(numbersExpected,fizzBuzzApp.createdListNumbers());
    }

    @Test
    public void addFizzToNumberListWhenNumberIsMultipleOfFive(){
        FizzBuzzApp fizzBuzzApp = new FizzBuzzApp(5);
        List<String> numbersExpected = new ArrayList<String>(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
        assertEquals(numbersExpected,fizzBuzzApp.createdListNumbers());
    }

    @Test
    public void addFizzToNumberListWhenNumberIsMultipleOfFiveAndThree(){
        FizzBuzzApp fizzBuzzApp = new FizzBuzzApp(20);
        List<String> numbersExpected = new ArrayList<String>(Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8",
                "Fizz","Buzz","11","Fizz","13","14","FizzBuzz","16","17","Fizz","19","Buzz"));
        assertEquals(numbersExpected,fizzBuzzApp.createdListNumbers());
    }

}
