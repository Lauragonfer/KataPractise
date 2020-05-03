public class FizzBuzzApp {

    private int sizeList;

    public FizzBuzzApp(int sizeList) {
        this.sizeList = sizeList;
    }


    public String createdListNumbers(){

        String numberList = "";

        for (int number = 1; number <= sizeList; number ++ ){
            numberList += checkNumberMultiple(number);
            }

        return  numberList;
    }


    private String checkNumberMultiple(int number) {
        if (isNumberMultiple3(number)){
            return "Fizz";
        }
        if (isNumberMultiple5(number)){

        }
        if (isNumberMultiple3and5(number)){

        }
        return ""+number;
    }

    private boolean isNumberMultiple3and5(int number) {
        return false;
    }

    private boolean isNumberMultiple5(int number) {
        return false;
    }

    private boolean isNumberMultiple3(int number) {

        if (number%3 == 0){
            return true;
        }
        return false;
    }


}
