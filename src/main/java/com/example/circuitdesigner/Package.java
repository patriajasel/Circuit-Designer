package com.example.circuitdesigner;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Package {

    String packageType;
    List<Component> components;

    public Package() {
        this.components = new ArrayList<>();
    }

}

class Component {
    String name;
    List<Wire> wires;
    List<Pad> pads;
    List<Text> texts;
    List<Smd> smd;
    List<Rectangle> rectangles;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Wire> getWires() {
        return wires;
    }

    public List<Pad> getPads() {
        return pads;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public List<Smd> getSmd() {
        return smd;
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Wire {
    double x1, y1, x2, y2, width;
    int layer;

    // Getter and Setter methods
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Pad {
    String name;
    double x, y, drill, diameter;

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDrill() {
        return drill;
    }

    public void setDrill(double drill) {
        this.drill = drill;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Text {
    double x, y, size;
    int layer, ratio;
    String font, align;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Smd {
    String name;
    double x, y, dx, dy;
    int layer;

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for x
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // Getter and Setter for y
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Getter and Setter for dx
    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    // Getter and Setter for dy
    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    // Getter and Setter for layer
    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Rectangle {
    double x1, y1, x2, y2;
    int layer;

    // Getter and Setter for x1
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    // Getter and Setter for y1
    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    // Getter and Setter for x2
    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    // Getter and Setter for y2
    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    // Getter and Setter for layer
    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}







