import java.util.List;

public class Format {


    public String formatNumberList(List <String> numberList){
        String numberListString = "";

        for (String number : numberList){
            numberListString += number+"\n";
        }

        return numberListString;
    }

}
