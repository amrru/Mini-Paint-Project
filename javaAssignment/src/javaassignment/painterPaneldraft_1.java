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

public class painterPaneldraft_1 extends JPanel implements ActionListener, MouseListener, MouseMotionListener, ItemListener {

    Button redButton, greenButton, blueButton, ovalButton, recButton, lineButton, freehandButton, eraserButton, clearAllButton;
    Checkbox dottedCheckedBox, filledCheckedBox;
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

    Vector<Integer> vectorLD = new Vector<>();
    Vector<Integer> vectorRD = new Vector<>();
    Vector<Integer> vectorOD = new Vector<>();
    Vector<Color> colorselectedVectorRect = new Vector<>();
    Vector<Color> colorselectedVectorOval = new Vector<>();
    Vector<Color> colorselectedVectorLine = new Vector<>();
    Vector<Color> colorselectedVectorRectDotted = new Vector<>();
    Vector<Color> colorselectedVectorOvalDotted = new Vector<>();
    Vector<Color> colorselectedVectorLineDotted = new Vector<>();

    Vector<Color> colorselectedVectorRectFill = new Vector<>();
    Vector<Color> colorselectedVectorOvalFill = new Vector<>();

    public painterPaneldraft_1() {

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

        add(redButton);

        add(blueButton);

        add(greenButton);

        add(ovalButton);

        add(recButton);

        add(lineButton);

        add(freehandButton);

        add(eraserButton);

        add(clearAllButton);

        add(dottedCheckedBox);

        add(filledCheckedBox);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorSelected);
        setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;

        /* to fill with shapes with colors */
        // Dotted rectangles
        for (int i = 0, rectIndex = 0; i + 3 < vectorRD.size(); i += 4, rectIndex++) {
            float[] dashPattern = {1.5f, 10f};
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, dashPattern, 0f));
            g2.setColor(colorselectedVectorRectDotted.get(rectIndex));
            g2.drawRect(vectorRD.get(i), vectorRD.get(i + 1), vectorRD.get(i + 2), vectorRD.get(i + 3));
        }

        // Dotted ovalss
        for (int i = 0, ovalIndex = 0; i + 3 < vectorOD.size(); i += 4, ovalIndex++) {
            float[] dashPattern = {1.5f, 10f};
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, dashPattern, 0f));
            g2.setColor(colorselectedVectorOvalDotted.get(ovalIndex));
            g2.drawOval(vectorOD.get(i), vectorOD.get(i + 1), vectorOD.get(i + 2), vectorOD.get(i + 3));
        }
        // Dotted Lines
        for (int i = 0, lineIndex = 0; i + 3 < vectorLD.size(); i += 4, lineIndex++) {
            float[] dashPattern = {1.5f, 10f};
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, dashPattern, 0f));
            g2.setColor(colorselectedVectorLineDotted.get(lineIndex));
            g2.drawLine(vectorLD.get(i), vectorLD.get(i + 1), vectorLD.get(i + 2), vectorLD.get(i + 3));
        }

        /* to draw a rectangle*/
        for (int i = 0, rectIndex = 0; i + 3 < vectorR.size(); i += 4, rectIndex++) {
            g2.setStroke(new BasicStroke(2f)); // solid
            g2.setColor(colorselectedVectorRect.get(rectIndex));
            g2.drawRect(vectorR.get(i), vectorR.get(i + 1), vectorR.get(i + 2), vectorR.get(i + 3));
        }


        /* to draw a oval*/
        for (int i = 0, ovalIndex = 0; i + 3 < vectorO.size(); i += 4, ovalIndex++) {
            g2.setStroke(new BasicStroke(2f)); // solid

            g2.setColor(colorselectedVectorOval.get(ovalIndex));
            g2.drawOval(vectorO.get(i), vectorO.get(i + 1), vectorO.get(i + 2), vectorO.get(i + 3));
        }
        /* to draw a line*/
        for (int i = 0, lineIndex = 0; i + 3 < vectorL.size(); i += 4, lineIndex++) {
            g2.setStroke(new BasicStroke(2f)); // solid

            g2.setColor(colorselectedVectorLine.get(lineIndex));
            g2.drawLine(vectorL.get(i), vectorL.get(i + 1), vectorL.get(i + 2), vectorL.get(i + 3));
        }
        /* to draw freehand*/
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        /* to draw a filled rectangle*/
        for (int i = 0, rectIndex = 0; i + 3 < vectorRF.size(); i += 4, rectIndex++) {
            g2.setColor(colorselectedVectorRectFill.get(rectIndex));

            g2.fillRect(vectorRF.get(i), vectorRF.get(i + 1), vectorRF.get(i + 2), vectorRF.get(i + 3));
            g2.drawRect(vectorRF.get(i), vectorRF.get(i + 1), vectorRF.get(i + 2), vectorRF.get(i + 3));
        }

        /* to draw a filled oval*/
        for (int i = 0, ovalIndex = 0; i + 3 < vectorOF.size(); i += 4, ovalIndex++) {
            g2.setColor(colorselectedVectorOvalFill.get(ovalIndex));
            g2.fillOval(vectorOF.get(i), vectorOF.get(i + 1), vectorOF.get(i + 2), vectorOF.get(i + 3));
            g2.drawOval(vectorOF.get(i), vectorOF.get(i + 1), vectorOF.get(i + 2), vectorOF.get(i + 3));
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

        } else if (src == greenButton) {
            colorSelected = Color.GREEN;

        } else if (src == blueButton) {
            colorSelected = Color.BLUE;

        } else {
            colorSelected = Color.BLACK;
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

        if (buttonflag == LINE) {
            if (!dotted_solid) {
                vectorL.add(x1);
                vectorL.add(y1);
                vectorL.add(x2);
                vectorL.add(y2);
                colorselectedVectorLine.add(colorSelected);
            } else {
                vectorLD.add(x1);
                vectorLD.add(y1);
                vectorLD.add(x2);
                vectorLD.add(y2);
                colorselectedVectorLineDotted.add(colorSelected);
            }
        } else if (buttonflag == RECTANGLE) {
            if (filledChoice) {

                vectorRF.add(x);
                vectorRF.add(y);
                vectorRF.add(w);
                vectorRF.add(h);
                colorselectedVectorRectFill.add(colorSelected);

            } else {
                if (!dotted_solid) {
                    vectorR.add(x);
                    vectorR.add(y);
                    vectorR.add(w);
                    vectorR.add(h);
                    colorselectedVectorRect.add(colorSelected);
                } else {
                    vectorRD.add(x);
                    vectorRD.add(y);
                    vectorRD.add(w);
                    vectorRD.add(h);
                    colorselectedVectorRectDotted.add(colorSelected);
                }
            }
        } else if (buttonflag == OVAL) {
            if (filledChoice) {
                vectorOF.add(x);
                vectorOF.add(y);
                vectorOF.add(w);
                vectorOF.add(h);
                colorselectedVectorOvalFill.add(colorSelected);
            } else {
                if (!dotted_solid) {
                    vectorO.add(x);
                    vectorO.add(y);
                    vectorO.add(w);
                    vectorO.add(h);
                    colorselectedVectorOval.add(colorSelected);
                } else {
                    vectorOD.add(x);
                    vectorOD.add(y);
                    vectorOD.add(w);
                    vectorOD.add(h);
                    colorselectedVectorOvalDotted.add(colorSelected);
                }
            }
        }
        repaint();
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
