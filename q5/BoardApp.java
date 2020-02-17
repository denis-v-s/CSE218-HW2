package q5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import q1.Stack;

public class BoardApp extends Application {
  private Stack<Button> stack = new Stack<>();
  private String black = "#170708";
  private String red = "#FF4C54";
  private Label lblMessage = new Label("");
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10, 10, 10, 10));
    Button btnBackTrack = new Button("BackTrack");
    btnBackTrack.setOnAction(e -> {
      if (!stack.isEmpty()) {
        Button b = stack.pop();
        b.setStyle("-fx-background-color: " + black);
        if (stack.isEmpty()) lblMessage.setText("No more buttons to turn black");
      }
    });
    vbox.getChildren().add(btnBackTrack);
    vbox.getChildren().add(lblMessage);
    
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 0, 0, 0));
    grid.setVgap(10);
    grid.setHgap(10);
    
    Button btn;
    int row = 3;
    int col = 3;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        btn = new Button();
        btn.setPrefSize(70, 30);
        btn.setStyle("-fx-background-color: " + black);
        btn.setOnAction(e ->  {
          Button b = (Button) e.getSource();
          b.setStyle("-fx-background-color: " + red);
          stack.push((Button) e.getSource());
          lblMessage.setText("");
        });
        grid.add(btn, i, j);
      }
    }
    vbox.getChildren().add(grid);
    
    Scene scene = new Scene(vbox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
