package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class CanvasFX extends Application {

    Canvas canvas;
    private ColorPicker colorPicker;
    private ShapeType shapeType = ShapeType.CIRCLE;

    @Override
    public void start(Stage primaryStage) throws Exception {
        canvas = new Canvas(400, 400);
        canvas.setOnMouseClicked(event -> canvasClicked(event));

        BorderPane root = new BorderPane();
        root.setCenter(canvas);

        Button circleButton = new Button("Circle");
        circleButton.setOnAction(event -> shapeType = ShapeType.CIRCLE);
        Button rectButton = new Button("Rectangle");
        rectButton.setOnAction(event -> shapeType = ShapeType.RECT);
        Button lineButton = new Button("Line");
        lineButton.setOnAction(event -> shapeType = ShapeType.LINE);

        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(circleButton);
        flowPane.getChildren().add(rectButton);
        flowPane.getChildren().add(lineButton);
        flowPane.getChildren().add(colorPicker);
        root.setTop(flowPane);

        var gc = canvas.getGraphicsContext2D();
        gc.setFill(new Color(0, 0, 1, 1));
        gc.fillOval(0, 0, 100, 100);
        gc.setFill(Color.LIME);
        gc.fillRect(200, 200, 100, 100);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void canvasClicked(MouseEvent event) {
        var gc = canvas.getGraphicsContext2D();
        gc.setFill(colorPicker.getValue());
        switch (shapeType) {
            case CIRCLE -> gc.fillOval(event.getX() - 10, event.getY() - 10, 20, 20);
            case RECT -> gc.fillRect(event.getX() - 10, event.getY() - 10, 20, 20);
            case LINE -> gc.strokeLine(event.getX(), event.getY(), 20, 0);
        }
    }
}
