import java.util.ArrayList;
import java.util.List;

public class FizzBuzzApp {

    private int sizeList;
    private Console console;

    public FizzBuzzApp(int sizeList) {
        this.sizeList = sizeList;
        this.console = new Console();
    }

    public void initFizzBuzz(){
        Format format = new Format();
        console.printNumberslist(format.formatNumberList(createdListNumbers()));
    }

    public  List<String>  createdListNumbers(){

        List<String> numberList = new ArrayList ();

        for (int number = 1; number <= sizeList; number ++ ){
            numberList.add(checkNumberMultiple(number));
            }

        return  numberList;
    }


    private String checkNumberMultiple(int number) {
        if (isNumberMultiple3and5(number)){
            return "FizzBuzz";
        }
        if (isNumberMultiple3(number)){
            return "Fizz";
        }
        if (isNumberMultiple5(number)){
            return  "Buzz";
        }
        return ""+number;
    }

    private boolean isNumberMultiple3and5(int number) {
        if(isNumberMultiple3(number) && isNumberMultiple5(number)){
            return true;
        }
        return false;
    }

    private boolean isNumberMultiple5(int number) {
        if (number%5 == 0){
            return true;
        }
        return false;
    }

    private boolean isNumberMultiple3(int number) {

        if (number%3 == 0){
            return true;
        }
        return false;
    }


}
