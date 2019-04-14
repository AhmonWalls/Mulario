import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


public class Q4_Mulario extends Application {
	@Override
	public void start(Stage primaryStage){
		BorderPane mainPane = new BorderPane();
		Pane pane = new Pane();
		HBox controls = new HBox(5);
		TextField r = new TextField();
		TextField g = new TextField();
		TextField b = new TextField();
		r.setPromptText("R Value");
		g.setPromptText("G Value");
		b.setPromptText("B Value");
		Button changeColor = new Button("Change Color");
		CheckBox checkbox = new CheckBox();
		checkbox.setText("Show Size");
		
		
		
		Circle player = new Circle();
		player.setCenterX(450);
		player.setCenterY(450);
		player.setRadius(15.0);
		player.setStroke(Color.BLACK);
		player.setFill(Color.GREEN);
		
		Circle food = new Circle();
		food.setCenterX(Math.random() * 900);
		food.setCenterY(Math.random() * 900);
		food.setRadius(10);
		food.setStroke(Color.BLACK);
		food.setFill(Color.color(Math.random(),Math.random(),Math.random()));
		
		
		
		pane.getChildren().add(food);
		pane.getChildren().add(player);
		controls.getChildren().add(r);
		controls.getChildren().add(g);
		controls.getChildren().add(b);
		controls.getChildren().add(changeColor);
		controls.getChildren().add(checkbox);
		
		
		mainPane.setCenter(pane);
		mainPane.setBottom(controls);
		
		
		changeColor.setOnAction(e -> changeColorHandle(player,r,g,b));
		
		Scene scene = new Scene(mainPane, 900, 900);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mulario");
		primaryStage.show();
		
		
		
		scene.setOnKeyPressed(e ->{
			switch (e.getCode()){
			case UP: player.setCenterY(player.getCenterY() - 10); if(isColliding(player,food)){moveFood(player,food);} break;
			case RIGHT: player.setCenterX(player.getCenterX() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case DOWN: player.setCenterY(player.getCenterY() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case LEFT: player.setCenterX(player.getCenterX() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			}
		});
		
		r.setOnKeyPressed(e ->{
			switch (e.getCode()){
			case UP: player.setCenterY(player.getCenterY() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case RIGHT: player.setCenterX(player.getCenterX() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case DOWN: player.setCenterY(player.getCenterY() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case LEFT: player.setCenterX(player.getCenterX() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			}
		});
		
		g.setOnKeyPressed(e ->{
			switch (e.getCode()){
			case UP: player.setCenterY(player.getCenterY() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case RIGHT: player.setCenterX(player.getCenterX() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case DOWN: player.setCenterY(player.getCenterY() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case LEFT: player.setCenterX(player.getCenterX() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			}
		});
		
		b.setOnKeyPressed(e ->{
			switch (e.getCode()){
			case UP: player.setCenterY(player.getCenterY() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case RIGHT: player.setCenterX(player.getCenterX() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case DOWN: player.setCenterY(player.getCenterY() + 10);if(isColliding(player,food)){moveFood(player,food);} break;
			case LEFT: player.setCenterX(player.getCenterX() - 10);if(isColliding(player,food)){moveFood(player,food);} break;
			}
		});
		
	}
	public static void main(String[] args){
		Q4_Mulario.launch();
	}
	
	public static void changeColorHandle(Circle player, TextField r, TextField g, TextField b){
		double red = Double.parseDouble(r.getText());
		double green = Double.parseDouble(g.getText());
		double blue = Double.parseDouble(b.getText());
		
		if(red > 255 || green > 255 || blue > 255){
			player.setFill(Color.BLACK);
		}else{
			player.setFill(Color.color(red/255, green/255, blue/255));
		}
	}
	
	
	public static boolean isColliding(Circle player, Circle food){
		double px = player.getCenterX();
		double py = player.getCenterY();
		double fx = food.getCenterX();
		double fy = food.getCenterY();
		double dx = px - fx;
		double dy = py - fy;
		double dist = player.getRadius() + food.getRadius();
		return dx*dx + dy*dy < dist*dist;
	}
	
	public static void moveFood(Circle player, Circle food){
		player.setRadius(player.getRadius()+5); 
		food.setCenterX(Math.random() * 900);
		food.setCenterY(Math.random() * 900);
		food.setFill(Color.color(Math.random(),Math.random(),Math.random()));
	}
	
	
}
