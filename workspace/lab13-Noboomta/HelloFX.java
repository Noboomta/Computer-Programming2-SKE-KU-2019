import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX Hello World application.
 * This shows how ridiculously over-complex java can be.
 */
public class HelloFX extends Application {
	private TextField nameField;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello Coder");
		// Create a container as root node in the Scene
		Pane root = initComponents();

		// Show the scene graph on the Stage
		primaryStage.setScene(new Scene(root));
		//primaryStage.sizeToScene();  // resize window to match Scene content
		primaryStage.show();
	}

	private FlowPane initComponents() {
		FlowPane root = new FlowPane();

		// Set appearance of container (spacing, alignment)
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10.0));
		root.setHgap(10.0);
		// Add components to the container
		Label prompt = new Label("Who are you?");
		nameField = new TextField();
		Button button = new Button("Greet me");
		EventHandler<ActionEvent> handler = this::handleGreetAction;
		button.setOnAction( handler );

		nameField.setOnAction(handler);
		root.getChildren().add(prompt);
		root.getChildren().add(nameField);
		root.getChildren().add(button);
		return root;
	}

	public void showDialog(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Greetings");
		alert.setHeaderText( message );
		// wait for user to dismiss dialog
		alert.showAndWait();
	}

	public void handleGreetAction(ActionEvent event){
		String name = nameField.getText().trim();
		if (name.isEmpty()) {
			nameField.setPromptText("please input a name");
		}
		else {
			// greet by name
			showDialog("Hello, "+name);
			nameField.clear();
		}
	}

}
