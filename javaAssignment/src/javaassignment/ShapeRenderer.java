package javaassignment;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class ShapeRenderer {
    private DrawingState drawingState;

    public ShapeRenderer(DrawingState drawingState) {
        this.drawingState = drawingState;
    }

    public void render(Graphics2D g2) {
        renderDottedRectangles(g2);
        renderDottedOvals(g2);
        renderDottedLines(g2);
        renderRectangles(g2);
        renderOvals(g2);
        renderLines(g2);
        renderFreehand(g2);
        renderFilledRectangles(g2);
        renderFilledOvals(g2);
        renderEraser(g2);
        renderDragPreview(g2);
    }

    private void renderDottedRectangles(Graphics2D g2) {
        for (int i = 0, rectIndex = 0; i + 3 < drawingState.vectorRD.size(); i += 4, rectIndex++) {
            float[] dashPattern = {1.5f, 10f};
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, dashPattern, 0f));
            g2.setColor(drawingState.colorselectedVectorRectDotted.get(rectIndex));
            g2.drawRect(drawingState.vectorRD.get(i), drawingState.vectorRD.get(i + 1), 
                        drawingState.vectorRD.get(i + 2), drawingState.vectorRD.get(i + 3));
        }
    }

    private void renderDottedOvals(Graphics2D g2) {
        for (int i = 0, ovalIndex = 0; i + 3 < drawingState.vectorOD.size(); i += 4, ovalIndex++) {
            float[] dashPattern = {1.5f, 10f};
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, dashPattern, 0f));
            g2.setColor(drawingState.colorselectedVectorOvalDotted.get(ovalIndex));
            g2.drawOval(drawingState.vectorOD.get(i), drawingState.vectorOD.get(i + 1), 
                        drawingState.vectorOD.get(i + 2), drawingState.vectorOD.get(i + 3));
        }
    }

    private void renderDottedLines(Graphics2D g2) {
        for (int i = 0, lineIndex = 0; i + 3 < drawingState.vectorLD.size(); i += 4, lineIndex++) {
            float[] dashPattern = {1.5f, 10f};
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, dashPattern, 0f));
            g2.setColor(drawingState.colorselectedVectorLineDotted.get(lineIndex));
            g2.drawLine(drawingState.vectorLD.get(i), drawingState.vectorLD.get(i + 1), 
                        drawingState.vectorLD.get(i + 2), drawingState.vectorLD.get(i + 3));
        }
    }

    private void renderRectangles(Graphics2D g2) {
        for (int i = 0, rectIndex = 0; i + 3 < drawingState.vectorR.size(); i += 4, rectIndex++) {
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(drawingState.colorselectedVectorRect.get(rectIndex));
            g2.drawRect(drawingState.vectorR.get(i), drawingState.vectorR.get(i + 1), 
                        drawingState.vectorR.get(i + 2), drawingState.vectorR.get(i + 3));
        }
    }

    private void renderOvals(Graphics2D g2) {
        for (int i = 0, ovalIndex = 0; i + 3 < drawingState.vectorO.size(); i += 4, ovalIndex++) {
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(drawingState.colorselectedVectorOval.get(ovalIndex));
            g2.drawOval(drawingState.vectorO.get(i), drawingState.vectorO.get(i + 1), 
                        drawingState.vectorO.get(i + 2), drawingState.vectorO.get(i + 3));
        }
    }

    private void renderLines(Graphics2D g2) {
        for (int i = 0, lineIndex = 0; i + 3 < drawingState.vectorL.size(); i += 4, lineIndex++) {
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(drawingState.colorselectedVectorLine.get(lineIndex));
            g2.drawLine(drawingState.vectorL.get(i), drawingState.vectorL.get(i + 1), 
                        drawingState.vectorL.get(i + 2), drawingState.vectorL.get(i + 3));
        }
    }

    private void renderFreehand(Graphics2D g2) {
        for (int i = 1; i < drawingState.points.size(); i++) {
            Point p1 = drawingState.points.get(i - 1);
            Point p2 = drawingState.points.get(i);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private void renderFilledRectangles(Graphics2D g2) {
        for (int i = 0, rectIndex = 0; i + 3 < drawingState.vectorRF.size(); i += 4, rectIndex++) {
            g2.setColor(drawingState.colorselectedVectorRectFill.get(rectIndex));
            g2.fillRect(drawingState.vectorRF.get(i), drawingState.vectorRF.get(i + 1), 
                        drawingState.vectorRF.get(i + 2), drawingState.vectorRF.get(i + 3));
            g2.drawRect(drawingState.vectorRF.get(i), drawingState.vectorRF.get(i + 1), 
                        drawingState.vectorRF.get(i + 2), drawingState.vectorRF.get(i + 3));
        }
    }

    private void renderFilledOvals(Graphics2D g2) {
        for (int i = 0, ovalIndex = 0; i + 3 < drawingState.vectorOF.size(); i += 4, ovalIndex++) {
            g2.setColor(drawingState.colorselectedVectorOvalFill.get(ovalIndex));
            g2.fillOval(drawingState.vectorOF.get(i), drawingState.vectorOF.get(i + 1), 
                        drawingState.vectorOF.get(i + 2), drawingState.vectorOF.get(i + 3));
            g2.drawOval(drawingState.vectorOF.get(i), drawingState.vectorOF.get(i + 1), 
                        drawingState.vectorOF.get(i + 2), drawingState.vectorOF.get(i + 3));
        }
    }

    private void renderEraser(Graphics2D g2) {
        for (int i = 0; i + 3 < drawingState.vectorE.size(); i += 4) {
            g2.setColor(Color.WHITE);
            g2.fillOval(drawingState.vectorE.get(i), drawingState.vectorE.get(i + 1), 20, 20);
            g2.drawOval(drawingState.vectorE.get(i), drawingState.vectorE.get(i + 1), 20, 20);
        }
    }

    private void renderDragPreview(Graphics2D g2) {
        if (drawingState.flagDrag) {
            if (drawingState.buttonflag == DrawingState.RECTANGLE) {
                g2.drawRect(drawingState.x, drawingState.y, drawingState.w, drawingState.h);
            } else if (drawingState.buttonflag == DrawingState.OVAL) {
                g2.drawOval(drawingState.x, drawingState.y, drawingState.w, drawingState.h);
            } else if (drawingState.buttonflag == DrawingState.LINE) {
                g2.drawLine(drawingState.x1, drawingState.y1, drawingState.x2, drawingState.y2);
            }
        }
    }
}
