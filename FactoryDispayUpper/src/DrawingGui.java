import javafx.scene.control.*;

import java.awt.*;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by johny on 10.02.16.
 */
public class DrawingGui extends Frame{
        public  Button button;

        public DrawingGui(GUI curentGui){
            // Create a frame with a button
            Frame frame = new Frame("Drawing Gui");
            // Create a component to add to the frame; in this case a text area with sample text
            TextField textFieldInput = new TextField("Enter text here");
            // Create a component to add to the frame; in this case a button
            button = new Button("Enter text");
            // Add the components to the frame; by default, the frame has a border layout
            frame.add(textFieldInput, BorderLayout.NORTH);
            frame.add(button, BorderLayout.SOUTH);
            // Show the frame
            int width = 300;
            int height = 300;
            frame.setSize(width, height);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    curentGui.setText(textFieldInput.getText());
                    System.exit(0);
                }
            });


            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });



            // Show window
            frame.setVisible(true);

        }
}

