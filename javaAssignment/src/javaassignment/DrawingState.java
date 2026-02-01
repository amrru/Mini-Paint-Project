package javaassignment;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

public class DrawingState {
    Color colorSelected;
    
    final static int OVAL = 1;
    final static int RECTANGLE = 2;
    final static int LINE = 3;
    final static int FREEHAND = 4;
    final static int ERASER = 5;
    final static int CLEARALL = 6;
    
    int buttonflag = -1;
    
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

    public void clearAll() {
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
    }
}
