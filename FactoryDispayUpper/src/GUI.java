import javafx.application.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by johny on 10.02.16.
 */
public class GUI extends UI{
    DrawingGui myDraw;
    public GUI (){
        myDraw = new DrawingGui(this);
    }

    @Override
    public void setText(String inptext) {
        text = inptext.toUpperCase();
    }

    @Override
    public String getText() {
        //boolean enteredText= false;
        if(!myDraw.isActive()) {
            return text;
        }
        return null;
    }
}
