package com.example.circuitdesigner;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class FootprintGenerator {

    public void drawFootprint(AnchorPane sketchBoard, Component components) {

        double offsetX = sketchBoard.getWidth() / 2;
        double offsetY = sketchBoard.getHeight() / 2;

        System.out.println(offsetX);
        System.out.println(offsetY);

        for (int i = 0; i < components.wires.size(); i++) {
            drawWire(sketchBoard, calculate(components.wires.get(i).x1) + offsetX , calculate(components.wires.get(i).y1) + offsetY, calculate(components.wires.get(i).x2) + offsetX, calculate(components.wires.get(i).y2) + offsetY) ;
        }

        for (int i = 0; i < components.pads.size(); i++) {
            drawPad(sketchBoard,calculate(components.pads.get(i).x) + offsetX, calculate(components.pads.get(i).y) + offsetY);
        }

        for (int i = 0; i < components.texts.size(); i++) {
            drawText(sketchBoard, "Text", calculate(components.texts.get(i).x) + offsetX, calculate(components.texts.get(i).y) + offsetY);
        }

    }

    public void drawWire(AnchorPane pane, double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1);
        pane.getChildren().add(line);;
    }

    private void drawPad(Pane pane, double centerX, double centerY) {
        Circle pad = new Circle(centerX , centerY , 2.5);
        pad.setFill(Color.BLACK);
        pane.getChildren().add(pad);
    }

    private void drawText(Pane pane, String textStr, double x, double y, String... rotation) {
        javafx.scene.text.Text text = new Text(x, y, textStr);
        text.setFont(Font.font("Arial", 6));
        text.setFill(Color.RED);

        if (rotation.length > 0) {
            text.setRotate(180);
        }

        pane.getChildren().add(text);
    }

    private double calculate(double num) {
        return (num / 25.4) * 102;
    }

}
