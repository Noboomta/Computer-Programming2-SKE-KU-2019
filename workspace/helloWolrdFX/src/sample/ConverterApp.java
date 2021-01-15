//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConverterApp extends Application {

    private TextField tf1;
    private TextField tf2;
    private ComboBox<Length> unitbox1;
    private ComboBox<Length> unitbox2;

//    private static final double MILES_PER_KM = 0.62137119D;

    public ConverterApp() {
    }

    public enum Length {
        // you must write the enum members first, separated by comma
        Kilometer(1000.0),
        Mile(1609.344),
        Meter(1.0),
        Centi(0.01),
        Foot(0.30480),
        Wa(2.0),
        LightY(9460730472580800l);
        // attribute of the enum members is number of meters per 1 unit
        private final double value;
        // enum constructor must be private
        private Length(double value) { this.value = value; }
        // methods are just like in a class
        public double getValue() { return this.value; }
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = this.initComponent();
        primaryStage.setTitle("Length Converter");
        primaryStage.setScene(new Scene(root, 670.0D, 50.0D));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private Pane initComponent() {
        FlowPane pane = new FlowPane();
        pane.setHgap(5.0D);
        pane.setVgap(5.0D);
        pane.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        this.tf1 = new TextField();
        this.tf2 = new TextField();
        this.unitbox1 = new ComboBox<Length>();
        this.unitbox1.getItems().addAll(Length.values());
        this.unitbox2 = new ComboBox<Length>();
        this.unitbox2.getItems().addAll(Length.values());
        Label lb1 = new Label("=");
        Button convertButton = new Button(" Convert! ");
        convertButton.setOnAction(new ConverterApp.ConvertHandler());
        Button clearButton = new Button(" Clear ");
        clearButton.setOnAction(new ClearHandler());
        pane.getChildren().addAll(new Node[]{this.tf1, unitbox1, lb1, this.tf2, unitbox2, convertButton, clearButton});
        return pane;
    }

    public static void main(String[] args) {
//        Length[] lengths = Length.values();
        // print the members and their value attribute
//        for(Length x : lengths)
//            System.out.println(x.toString()+" = "+x.getValue());
        launch(args);
    }

    class ConvertHandler implements EventHandler<ActionEvent> {
        Double result;
        Length unit1;
        Length unit2;
        ConvertHandler() {
        }

        public void handle(ActionEvent actionEvent) {
            if (!ConverterApp.this.tf1.getText().isEmpty() && ConverterApp.this.tf2.getText().isEmpty()) {
                try {
                    result = Double.parseDouble(ConverterApp.this.tf1.getText());
                    unit1 = unitbox1.getValue();
                    unit2 = unitbox2.getValue();
                    ConverterApp.this.tf2.setPromptText(String.format("%.5f", (result * unit1.getValue()) / unit2.getValue()));
                } catch (NumberFormatException var3) {
                    ConverterApp.this.tf1.clear();
                    ConverterApp.this.tf2.clear();
                    ConverterApp.this.tf1.setPromptText("please enter a number.");
                }
            }
            else if (ConverterApp.this.tf1.getText().isEmpty() && !ConverterApp.this.tf2.getText().isEmpty()) {
                try {
                    result = Double.parseDouble(ConverterApp.this.tf2.getText());
                    unit1 = unitbox1.getValue();
                    unit2 = unitbox2.getValue();
                    ConverterApp.this.tf1.setPromptText(String.format("%.5f", (result * unit2.getValue()) / unit1.getValue()));
                } catch (NumberFormatException var4) {
                    ConverterApp.this.tf1.clear();
                    ConverterApp.this.tf2.clear();
                    ConverterApp.this.tf2.setPromptText("please enter a number.");
                }
            }
            else if (!ConverterApp.this.tf1.getText().isEmpty() && !ConverterApp.this.tf2.getText().isEmpty()) {
                tf1.clear();
                tf2.clear();

            }

        }
    }

    class ClearHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            tf1.clear();
            tf2.clear();
        }
    }

}