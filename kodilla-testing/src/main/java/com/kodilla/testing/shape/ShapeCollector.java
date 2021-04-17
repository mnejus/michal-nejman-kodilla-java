package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        if(n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        String figures = "";
        for(int n = 0; n < shapes.size()-1; n++) {
            figures += (shapes.get(n).getShapeName() + ", ");
        }
        figures += shapes.get(shapes.size()-1).getShapeName();

        return figures;
    }

}
