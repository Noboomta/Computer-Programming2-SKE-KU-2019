package converter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 * Class of Converter app to convert the unit to another unit.
 */
public class ConverterApp extends Application {
    @FXML
    private TextField numberleftField;
    @FXML
    private TextField numberrightField;
    @FXML
    private ComboBox<Unit> comboBox1;
    @FXML
    private ComboBox<Unit> comboBox2;
    @FXML
    private Menu menu;

    /**
     * The start method of class
     * @param primaryStage the Stage.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Converter");

        VBox root = initComponents();

        primaryStage.setScene(new Scene(root, 900, 70));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * InitComponent shorter the starter code to be method.
     * @return Flowplane.
     */
    private VBox initComponents() {
        VBox vBox = new VBox();
        FlowPane root = new FlowPane();
        UnitFactory unitFactory = new UnitFactory();

        root.setAlignment(Pos.CENTER);
        root.setPadding( new Insets(10.0, 15.0, 10.0, 15.0));
        root.setHgap(10.0);
        root.setVgap(10.0);

        String[] unitTypes = unitFactory.getUnitTypes();
        menu = new Menu("Unit Types");
        for(String unit: unitTypes){
            MenuItem menuItem = new MenuItem(unit);
            menuItem.setOnAction(new MenuHandler(unit));
            menu.getItems().add(menuItem);
        }
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem exit = new MenuItem( "Exit");
        menu.getItems() .add(separator);
        menu.getItems() .add(exit);
        exit.setOnAction(actionEvent -> Platform.exit());
        MenuBar menuBar = new MenuBar(this.menu);
        menuBar.setStyle("-fx-border-color: #041bd3");

        Label prompt1 = new Label("=");

        numberleftField = new TextField();
        numberrightField = new TextField();
        comboBox1 = new ComboBox<Unit>();
        comboBox2 = new ComboBox<Unit>();
        comboBox1.setStyle("-fx-pref-width: 100");
        comboBox2.setStyle("-fx-pref-width: 100");

        Button convertButton = new Button("Convert!");
        Button clearButton = new Button("Clear");
        convertButton.setOnAction( new ConvertHandler());
        clearButton.setOnAction( new ClearHandler());

        root.getChildren().add(numberleftField);
        root.getChildren().add(comboBox1);
        root.getChildren().add(prompt1);
        root.getChildren().add(numberrightField);
        root.getChildren().add(comboBox2);
        root.getChildren().add(convertButton);
        root.getChildren().add(clearButton);

        vBox.getChildren().add(menuBar);
        vBox.getChildren().add(root);
        return vBox;
    }

    /**
     * Class to show the window dialog.
     * @param message message to appear on the window.
     */
    public void showDialog(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.setContentText("Must be number");
        alert.showAndWait();
    }

    /**
     * Handler of the convert app.
     */
    class ConvertHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            numberleftField.setStyle("-fx-border-color: black");
            numberrightField.setStyle("-fx-border-color: black");
            String text1 = numberleftField.getText();
            String text2 = numberrightField.getText();
            Unit unit1 = comboBox1.getValue();
            Unit unit2 = comboBox2.getValue();
            if(!text1.isEmpty() && text2.isEmpty()){
                try{
                    double leftNum = Double.parseDouble(text1);
                    double converted = unit2.convert(leftNum, unit1);
                    numberrightField.setPromptText(converted+"");
                }catch (NumberFormatException e){
                    numberleftField.setStyle("-fx-border-color: red");
                    showDialog("Please Enter Number!");
                }
            }

            else if(text1.isEmpty() && !text2.isEmpty()){
                try{
                    double rightNum = Double.parseDouble(text2);
                    double converted = unit1.convert(rightNum, unit2);
                    numberleftField.setPromptText(converted+"");
                }catch (NumberFormatException e){
                    numberrightField.setStyle("-fx-border-color: red");
                    showDialog("Please Enter Number!");
                }
            }
            else {
                numberleftField.clear();
                numberrightField.clear();
                numberleftField.setPromptText("");
                numberrightField.setPromptText("");
            }

        }
    }


    /**
     * Handler of clear button.
     */
    class ClearHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            numberleftField.clear();
            numberrightField.clear();
            numberleftField.setPromptText("");
            numberrightField.setPromptText("");
        }
    }

    private class MenuHandler implements EventHandler<ActionEvent> {
        private String unit;
        public MenuHandler(String unit) {
            this.unit = unit;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            comboBox1.getItems().clear();
            comboBox1.getItems().addAll(UnitFactory.getUnits(this.unit));
            comboBox2.getItems().clear();
            comboBox2.getItems().addAll(UnitFactory.getUnits(this.unit));
        }
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}