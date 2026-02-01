/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
 * @author Amr
 */
public class oneLine extends JPanel implements MouseListener, MouseMotionListener{
    int x1=0;
    int y1 = 0;
    int x2=0;
    int y2=0;
    Label l1;
    
    public oneLine(){
         addMouseListener(this);
         addMouseMotionListener(this);
    }

    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(x1,y1, x2, y2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
         x1= e.getX();
        y1= e.getY();
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2= e.getX();
        y2=e.getY();
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
     
}

