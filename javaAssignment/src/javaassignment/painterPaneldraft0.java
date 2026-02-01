/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class painterPaneldraft0 extends JPanel implements ActionListener, MouseListener, MouseMotionListener, ItemListener {

    Button redButton, greenButton, blueButton, ovalButton, recButton, lineButton, freehandButton, eraserButton, clearAllButton;
    Checkbox dottedCheckedBox, filledCheckedBox;
    Label redLabel, greenLabel, blueLabel, ovalLabel, recLabel, lineLabel, freehandLabel, eraserLabel, clearAllLabel, dottedLabel, filledLabel;
    Color colorSelected;
    //consts for shapes
    final static int OVAL = 1;
    final static int RECTANGLE = 2;
    final static int LINE = 3;
    final static int FREEHAND = 4;
    final static int ERASER = 5;
    final static int CLEARALL = 6;
    int buttonflag = -1;
    //for coordinates
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    boolean flagDrag = false;
    boolean dotted_solid = false;
    boolean filledChoice = false;
    int limitx;
    int limity;
    Vector<Integer> vectorL = new Vector<>();
    Vector<Integer> vectorR = new Vector<>();
    Vector<Integer> vectorO = new Vector<>();
    Vector<Integer> vectorRF = new Vector<>();
    Vector<Integer> vectorOF = new Vector<>();
    Vector<Point> points = new Vector<>();
    Vector<Integer> vectorE = new Vector<>();
    
    Vector<Integer> vectorLD= new Vector<>();
    Vector<Integer> vectorRD = new Vector<>();
    Vector<Integer> vectorOD = new Vector<>();
    
    
    public painterPaneldraft0() {

        greenLabel = new Label("Green");
        redLabel = new Label("Red");
        blueLabel = new Label("Blue");
        ovalLabel = new Label("Oval");
        recLabel = new Label("Rectangle");
        lineLabel = new Label("Line");
        freehandLabel = new Label("Free Hand");
        eraserLabel = new Label("Eraser");
        clearAllLabel = new Label("Clear All");
        dottedLabel = new Label("Dotted/Solid");
        filledLabel = new Label("Fill color");

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

        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        ovalButton.addActionListener(this);
        recButton.addActionListener(this);
        lineButton.addActionListener(this);
        freehandButton.addActionListener(this);
        eraserButton.addActionListener(this);
        clearAllButton.addActionListener(this);
        dottedCheckedBox.addItemListener(this);
        filledCheckedBox.addItemListener(this);

        addMouseListener(this);
        addMouseMotionListener(this);

        setLayout(new FlowLayout());

        //  add(redLabel);
        add(redButton);

        // add(blueLabel);
        add(blueButton);

        // add(greenLabel);
        add(greenButton);

        // add(ovalLabel);
        add(ovalButton);
        //  add(recLabel);
        add(recButton);

        //    add(lineLabel);
        add(lineButton);

        // add(freehandLabel);
        add(freehandButton);

        //add(eraserLabel);
        add(eraserButton);

        //  add(clearAllLabel);
        add(clearAllButton);

        // add(dottedLabel);
        add(dottedCheckedBox);

        // add(filledLabel);
        add(filledCheckedBox);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorSelected);
        setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;

        /* to create a dotted shape */
        if (dotted_solid) {
            // Create a dotted stroke (dash pattern)
            float[] dashPattern = {1.5f, 10f};
            Stroke dotted = new BasicStroke(
                    2f,
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND,
                    10f,
                    dashPattern,
                    0f
            );

            g2.setStroke(dotted);

        }

        /* to fill with shapes with colors */
    //    if (filledChoice) {

            /* to draw a rectangle*/
            for (int i = 0; i + 3 < vectorRF.size(); i += 4) {
                g2.fillRect(vectorRF.get(i), vectorRF.get(i + 1), vectorRF.get(i + 2), vectorRF.get(i + 3));
                g2.drawRect(vectorRF.get(i), vectorRF.get(i + 1), vectorRF.get(i + 2), vectorRF.get(i + 3));
            }
            /* to draw a oval*/
            for (int i = 0; i + 3 < vectorOF.size(); i += 4) {
                g2.fillOval(vectorOF.get(i), vectorOF.get(i + 1), vectorOF.get(i + 2), vectorOF.get(i + 3));
                g2.drawOval(vectorOF.get(i), vectorOF.get(i + 1), vectorOF.get(i + 2), vectorOF.get(i + 3));
            }

      //  }

        /* to draw a rectangle*/
        for (int i = 0; i + 3 < vectorR.size(); i += 4) {
            g2.drawRect(vectorR.get(i), vectorR.get(i + 1), vectorR.get(i + 2), vectorR.get(i + 3));

        }
        /* to draw a oval*/
        for (int i = 0; i + 3 < vectorO.size(); i += 4) {
            g2.drawOval(vectorO.get(i), vectorO.get(i + 1), vectorO.get(i + 2), vectorO.get(i + 3));
        }
        /* to draw a line*/
        for (int i = 0; i + 3 < vectorL.size(); i += 4) {
            g2.drawLine(vectorL.get(i), vectorL.get(i + 1), vectorL.get(i + 2), vectorL.get(i + 3));
        }
        /* to draw freehand*/
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        /* to erase*/
        for (int i = 0; i + 3 < vectorE.size(); i += 4) {
            g2.setColor(Color.WHITE);
            g2.fillOval(vectorE.get(i), vectorE.get(i + 1), 20, 20);
            g2.drawOval(vectorE.get(i), vectorE.get(i + 1), 20, 20);
        }
        /* to draw the first instance */
        if (flagDrag) {
            if (buttonflag == RECTANGLE) {
                g2.drawRect(x, y, w, h);
            } else if (buttonflag == OVAL) {
                g2.drawOval(x, y, w, h);
            } else if (buttonflag == LINE) {
                g2.drawLine(x1, y1, x2, y2);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        /* to select a color */
        if (src == redButton) {
            colorSelected = Color.RED;
            this.repaint();
        } else if (src == greenButton) {
            colorSelected = Color.GREEN;
            this.repaint();
        } else if (src == blueButton) {
            colorSelected = Color.BLUE;
            this.repaint();
        }

        /* to select to draw a shape */
        if (src == ovalButton) {
            buttonflag = OVAL;
        } else if (src == recButton) {
            buttonflag = RECTANGLE;
        } else if (src == lineButton) {
            buttonflag = LINE;
        } else if (src == freehandButton) {
            buttonflag = FREEHAND;
        } /* to select eraser */ else if (src == eraserButton) {
            buttonflag = ERASER;
        } /* to select clear all*/ else if (src == clearAllButton) {
            buttonflag = CLEARALL;
            vectorE.clear();
            vectorL.clear();
            vectorO.clear();
            vectorR.clear();
            vectorOF.clear();
            vectorRF.clear();
   vectorLD.clear();
   vectorRD.clear();
   vectorOD.clear();
            
            
            points.clear();
            repaint();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*to get the x and y of the point at first click */
        x1 = e.getX();
        y1 = e.getY();
        if (buttonflag == FREEHAND) {
            points.add(e.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        flagDrag = false;
        x2 = e.getX();
        y2 = e.getY();
        /* to add the final coordinates to the line */
        if (buttonflag == LINE) {
            vectorL.add(x1);
            vectorL.add(y1);
            vectorL.add(x2);
            vectorL.add(y2);
            /* to add the final coordinates to the rect */
        } else if (buttonflag == RECTANGLE) {

            if (filledChoice) {
                vectorRF.add(x);
                vectorRF.add(y);
                vectorRF.add(w);
                vectorRF.add(h);
            } else {
                vectorR.add(x);
                vectorR.add(y);
                vectorR.add(w);
                vectorR.add(h);
            }

            /* to add the final coordinates to the oval */
        } else if (buttonflag == OVAL) {
            if (filledChoice) {
                vectorOF.add(x);
                vectorOF.add(y);
                vectorOF.add(w);
                vectorOF.add(h);
            } else {
                vectorO.add(x);
                vectorO.add(y);
                vectorO.add(w);
                vectorO.add(h);
            }

        }
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        flagDrag = true;
        Graphics g = getGraphics();

        /*to draw any shape with negative coordinates */
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        w = Math.abs(x2 - x1);
        h = Math.abs(y2 - y1);

        /* to add the points automatically to the points vector for free hand drawing */
        if (buttonflag == FREEHAND) {
            points.add(e.getPoint());
        } /* to add the coordinates of oval automatically for erasing */ else if (buttonflag == ERASER) {
            vectorE.add(x2);
            vectorE.add(y2);
            /* to draw the oval as a shape while i'm dragging (indicator) */
            g.drawOval(x2, y2, 20, 20);

        }

        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (dottedCheckedBox.getState()) {
            dotted_solid = true;
        } else if (!dottedCheckedBox.getState()) {
            dotted_solid = false;
        }

        if (filledCheckedBox.getState()) {
            filledChoice = true;

        } else if (!filledCheckedBox.getState()) {
            filledChoice = false;
        }
        this.repaint();
    }

}
