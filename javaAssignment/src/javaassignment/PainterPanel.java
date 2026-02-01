package javaassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class PainterPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, ItemListener {

    private UIComponents uiComponents;
    private DrawingState drawingState;
    private ShapeRenderer shapeRenderer;
    private MouseHandler mouseHandler;

    public PainterPanel() {
        uiComponents = new UIComponents();
        drawingState = new DrawingState();
        shapeRenderer = new ShapeRenderer(drawingState);
        mouseHandler = new MouseHandler(drawingState);

        uiComponents.addListeners(this, this, this);
        addMouseListener(this);
        addMouseMotionListener(this);

        setLayout(new FlowLayout());
        uiComponents.addComponentsToPanel(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(drawingState.colorSelected);
        setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;
        shapeRenderer.render(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src == uiComponents.redButton) {
            drawingState.colorSelected = Color.RED;
        } else if (src == uiComponents.greenButton) {
            drawingState.colorSelected = Color.GREEN;
        } else if (src == uiComponents.blueButton) {
            drawingState.colorSelected = Color.BLUE;
        } else {
            drawingState.colorSelected = Color.BLACK;
        }

        if (src == uiComponents.ovalButton) {
            drawingState.buttonflag = DrawingState.OVAL;
        } else if (src == uiComponents.recButton) {
            drawingState.buttonflag = DrawingState.RECTANGLE;
        } else if (src == uiComponents.lineButton) {
            drawingState.buttonflag = DrawingState.LINE;
        } else if (src == uiComponents.freehandButton) {
            drawingState.buttonflag = DrawingState.FREEHAND;
        } else if (src == uiComponents.eraserButton) {
            drawingState.buttonflag = DrawingState.ERASER;
        } else if (src == uiComponents.clearAllButton) {
            drawingState.clearAll();
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseHandler.handleMousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseHandler.handleMouseReleased(e);
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
        mouseHandler.handleMouseDragged(e, getGraphics());
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (uiComponents.dottedCheckedBox.getState()) {
            drawingState.dotted_solid = true;
        } else if (!uiComponents.dottedCheckedBox.getState()) {
            drawingState.dotted_solid = false;
        }

        if (uiComponents.filledCheckedBox.getState()) {
            drawingState.filledChoice = true;
        } else if (!uiComponents.filledCheckedBox.getState()) {
            drawingState.filledChoice = false;
        }
        this.repaint();
    }
}
