package javaassignment;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JPanel;

public class UIComponents {
    Button redButton, greenButton, blueButton, ovalButton, recButton, lineButton, freehandButton, eraserButton, clearAllButton;
    Checkbox dottedCheckedBox, filledCheckedBox;

    public UIComponents() {
        redButton = new Button("red");
        blueButton = new Button("blue");
        greenButton = new Button("green");
        ovalButton = new Button("Oval");
        recButton = new Button("rec");
        lineButton = new Button("Line");
        freehandButton = new Button("free");
        eraserButton = new Button("Eraser");
        clearAllButton = new Button("clear");
        dottedCheckedBox = new Checkbox("dotted");
        filledCheckedBox = new Checkbox("fill color");
    }

    public void addListeners(ActionListener actionListener, ItemListener itemListener1, ItemListener itemListener2) {
        redButton.addActionListener(actionListener);
        blueButton.addActionListener(actionListener);
        greenButton.addActionListener(actionListener);
        ovalButton.addActionListener(actionListener);
        recButton.addActionListener(actionListener);
        lineButton.addActionListener(actionListener);
        freehandButton.addActionListener(actionListener);
        eraserButton.addActionListener(actionListener);
        clearAllButton.addActionListener(actionListener);
        dottedCheckedBox.addItemListener(itemListener1);
        filledCheckedBox.addItemListener(itemListener2);
    }

    public void addComponentsToPanel(JPanel panel) {
        panel.add(redButton);
        panel.add(blueButton);
        panel.add(greenButton);
        panel.add(ovalButton);
        panel.add(recButton);
        panel.add(lineButton);
        panel.add(freehandButton);
        panel.add(eraserButton);
        panel.add(clearAllButton);
        panel.add(dottedCheckedBox);
        panel.add(filledCheckedBox);
    }
}
