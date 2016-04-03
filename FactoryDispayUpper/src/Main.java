import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Select GUI(1) or CUI(2) ?");
        Scanner scan = new Scanner(System.in);
        String choose = scan.next();
        UI ui = null;
        if(choose.equals("1"))
        {
            ui = new GUI();
        }
        else if(choose.equals("2"))
        {
            ui = new CUI();
        }
        else {
            System.out.println("error");
            System.exit(0);
        }

        String currentText = ui.getText();
        while (currentText == null)
        {
            currentText = ui.getText();
        }
        System.out.println("The text is " + currentText);
    }
}
