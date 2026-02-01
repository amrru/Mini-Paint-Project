/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaassignment;

import javax.swing.JFrame;

/**
 *
 * @author Amr
 */
public class JavaAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //painter frame = new painter();
        //arrows frame = new arrows();
        //oneLine frame = new oneLine();

        //frame.setSize(700, 700);
        //frame.setVisible(true);
        //=========================
        JFrame frame = new JFrame();
        frame.setTitle("Hello world frame");
        PainterPanel f = new PainterPanel();
        //  painterPaneldraft_1 f = new painterPaneldraft_1();
        //oneLine1_2 f = new  oneLine1_2();
        // multiLine1 f = new multiLine1();
        //PainterPanel f = new PainterPanel();
        frame.setContentPane(f);
        frame.setSize(700, 700);
        frame.setVisible(true);
    }

}
