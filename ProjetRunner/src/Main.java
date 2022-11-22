import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

     @Override
     public void start(Stage primaryStage) throws Exception{

          primaryStage.setTitle("Hello world");
          Group root = new Group();
          Pane pane = new Pane(root);
          GameScene theScene = new GameScene(pane, 1200, 400,true);
          primaryStage.setScene(theScene);
          primaryStage.show();
          System.out.println(GameScene.Cam.toString());
          theScene.render(GameScene.Cam);
          AnimationTimer timer = new AnimationTimer() {
               public void handle(long time) {
                    AnimatedThing.update(time);
                    theScene.Cam.update(time);
                    theScene.update(time);
               }
          };
          timer.start();
     }


     public static void main(String[] args) {
          launch(args);


     }
}
