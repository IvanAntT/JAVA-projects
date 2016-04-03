import java.util.Scanner;

/**
 * Created by johny on 10.02.16.
 */
public class CUI extends UI {

    public CUI (){
        System.out.println("Enter Word");
        Scanner scan = new Scanner(System.in);
        text = scan.next();
    }

    @Override
    public void setText(String text) {

    }

    @Override
    public String getText() {
        String upText = text.toUpperCase();
        return upText;
    }
}
