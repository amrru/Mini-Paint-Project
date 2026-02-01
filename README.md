[README.txt](https://github.com/user-attachments/files/24995629/README.txt)
================================================================================
                    PAINT APPLICATION - README
================================================================================

PROJECT OVERVIEW
================================================================================
This is a Java-based paint application that allows users to draw various shapes
and freehand drawings on a canvas. The application features a simple GUI with
buttons for color selection, shape tools, and drawing options.

FEATURES
================================================================================
1. Color Selection:
   - Red
   - Green
   - Blue
   - Black (default)

2. Drawing Tools:
   - Oval: Draw circular/elliptical shapes
   - Rectangle: Draw rectangular shapes
   - Line: Draw straight lines
   - Freehand: Draw freely with mouse
   - Eraser: Erase parts of the drawing

3. Drawing Styles:
   - Solid lines (default)
   - Dotted lines (checkbox option)
   - Filled shapes (checkbox option)

4. Additional Features:
   - Clear All: Removes all drawings from the canvas
   - Drag preview: See shape outline while drawing
   - Support for negative coordinate drawing


PROJECT STRUCTURE
================================================================================
The project consists of 6 main classes organized using MVC design pattern:

1. JavaAssignment.java
   - Main entry point of the application
   - Creates and displays the main window

2. PainterPanel.java
   - Main controller class
   - Coordinates all components
   - Handles all user events (mouse, buttons, checkboxes)

3. UIComponents.java
   - Manages all UI elements (buttons and checkboxes)
   - Handles component initialization and layout

4. DrawingState.java
   - Model class that stores all application state
   - Maintains all drawn shapes in vectors
   - Manages current drawing settings

5. ShapeRenderer.java
   - View class responsible for rendering
   - Draws all shapes to the canvas
   - Handles different drawing styles (solid, dotted, filled)

6. MouseHandler.java
   - Processes mouse events
   - Manages drawing operations based on mouse input
   - Updates drawing state


RUNNING THE APPLICATION
================================================================================
After compilation, run the application:

   java javaassignment.JavaAssignment

The application window will open with dimensions 700x700 pixels.

HOW TO USE
================================================================================
1. Select a Color:
   - Click on "red", "green", or "blue" button
   - Default color is black

2. Select a Tool:
   - Click "Oval" to draw ovals
   - Click "rec" to draw rectangles
   - Click "Line" to draw lines
   - Click "free" for freehand drawing
   - Click "Eraser" to erase

3. Drawing:
   - Click and drag on the canvas to draw
   - Release mouse to finalize the shape
   - For lines: drag from start point to end point
   - For freehand: drag to draw continuous lines

4. Style Options:
   - Check "dotted" for dotted lines/shapes
   - Check "fill color" to fill shapes with selected color
   - Uncheck to return to default solid outline

5. Clear Canvas:
   - Click "clear" button to remove all drawings



By: Amr Khaled & Hager Elwan
================================================================================
                         END OF README
================================================================================
