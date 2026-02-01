package javaassignment;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class MouseHandler {
    private DrawingState drawingState;

    public MouseHandler(DrawingState drawingState) {
        this.drawingState = drawingState;
    }

    public void handleMousePressed(MouseEvent e) {
        drawingState.x1 = e.getX();
        drawingState.y1 = e.getY();
        if (drawingState.buttonflag == DrawingState.FREEHAND) {
            drawingState.points.add(e.getPoint());
        }
    }

    public void handleMouseReleased(MouseEvent e) {
        drawingState.flagDrag = false;
        drawingState.x2 = e.getX();
        drawingState.y2 = e.getY();

        if (drawingState.buttonflag == DrawingState.LINE) {
            if (!drawingState.dotted_solid) {
                drawingState.vectorL.add(drawingState.x1);
                drawingState.vectorL.add(drawingState.y1);
                drawingState.vectorL.add(drawingState.x2);
                drawingState.vectorL.add(drawingState.y2);
                drawingState.colorselectedVectorLine.add(drawingState.colorSelected);
            } else {
                drawingState.vectorLD.add(drawingState.x1);
                drawingState.vectorLD.add(drawingState.y1);
                drawingState.vectorLD.add(drawingState.x2);
                drawingState.vectorLD.add(drawingState.y2);
                drawingState.colorselectedVectorLineDotted.add(drawingState.colorSelected);
            }
        } else if (drawingState.buttonflag == DrawingState.RECTANGLE) {
            if (drawingState.filledChoice) {
                drawingState.vectorRF.add(drawingState.x);
                drawingState.vectorRF.add(drawingState.y);
                drawingState.vectorRF.add(drawingState.w);
                drawingState.vectorRF.add(drawingState.h);
                drawingState.colorselectedVectorRectFill.add(drawingState.colorSelected);
            } else {
                if (!drawingState.dotted_solid) {
                    drawingState.vectorR.add(drawingState.x);
                    drawingState.vectorR.add(drawingState.y);
                    drawingState.vectorR.add(drawingState.w);
                    drawingState.vectorR.add(drawingState.h);
                    drawingState.colorselectedVectorRect.add(drawingState.colorSelected);
                } else {
                    drawingState.vectorRD.add(drawingState.x);
                    drawingState.vectorRD.add(drawingState.y);
                    drawingState.vectorRD.add(drawingState.w);
                    drawingState.vectorRD.add(drawingState.h);
                    drawingState.colorselectedVectorRectDotted.add(drawingState.colorSelected);
                }
            }
        } else if (drawingState.buttonflag == DrawingState.OVAL) {
            if (drawingState.filledChoice) {
                drawingState.vectorOF.add(drawingState.x);
                drawingState.vectorOF.add(drawingState.y);
                drawingState.vectorOF.add(drawingState.w);
                drawingState.vectorOF.add(drawingState.h);
                drawingState.colorselectedVectorOvalFill.add(drawingState.colorSelected);
            } else {
                if (!drawingState.dotted_solid) {
                    drawingState.vectorO.add(drawingState.x);
                    drawingState.vectorO.add(drawingState.y);
                    drawingState.vectorO.add(drawingState.w);
                    drawingState.vectorO.add(drawingState.h);
                    drawingState.colorselectedVectorOval.add(drawingState.colorSelected);
                } else {
                    drawingState.vectorOD.add(drawingState.x);
                    drawingState.vectorOD.add(drawingState.y);
                    drawingState.vectorOD.add(drawingState.w);
                    drawingState.vectorOD.add(drawingState.h);
                    drawingState.colorselectedVectorOvalDotted.add(drawingState.colorSelected);
                }
            }
        }
    }

    public void handleMouseDragged(MouseEvent e, Graphics g) {
        drawingState.x2 = e.getX();
        drawingState.y2 = e.getY();
        drawingState.flagDrag = true;

        drawingState.x = Math.min(drawingState.x1, drawingState.x2);
        drawingState.y = Math.min(drawingState.y1, drawingState.y2);
        drawingState.w = Math.abs(drawingState.x2 - drawingState.x1);
        drawingState.h = Math.abs(drawingState.y2 - drawingState.y1);

        if (drawingState.buttonflag == DrawingState.FREEHAND) {
            drawingState.points.add(e.getPoint());
        } else if (drawingState.buttonflag == DrawingState.ERASER) {
            drawingState.vectorE.add(drawingState.x2);
            drawingState.vectorE.add(drawingState.y2);
            g.drawOval(drawingState.x2, drawingState.y2, 20, 20);
        }
    }
}
