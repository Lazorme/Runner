import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class GameScene extends Scene {

    protected static Camera Cam;

    protected Pane pane;

    protected StaticThing backgroundLeft;
    protected StaticThing backgroundRight;

    protected StaticThing numberOfLives;

    protected Hero Character;

    AnimationTimer timer;

    public void update(long time) {
        if (Objects.equals(AnimatedThing.countFrame, AnimatedThing.maxFrame)){
            Cam.setX(Cam.getX()+20);
            this.render(Cam);


            AnimatedThing.countFrame = 0;
        }
        else {
            AnimatedThing.countFrame+=1;
        }
    }
    public GameScene(Pane ParentPane, double v, double v1, boolean b) {
        super(ParentPane, v, v1, b);
        pane = ParentPane;
        Cam = new Camera(2000,50,600,400); //Child 0
        backgroundLeft = new StaticThing(800,400,0,0,"file:img/desert.png", 0); //Child 1
        backgroundRight = new StaticThing(800,400,800,0,"file:img/desert.png",0); //Child 2
        numberOfLives = new StaticThing(900,200,20,20,"file:img/lives.png",3); //Child 3
        Character = new Hero("file:img/heros.png", 100,200,0); //Child 4
        ParentPane.getChildren().add(backgroundLeft.getBackground());
        ParentPane.getChildren().add(backgroundRight.getBackground());
        ParentPane.getChildren().add(numberOfLives.getBackground());
        ParentPane.getChildren().add(Character.getSprite());
        ParentPane.getChildren().get(3).setScaleX(0.15);
        ParentPane.getChildren().get(3).setScaleY(0.15);
    };





    public void render (Camera C){

        ((ImageView) pane.getChildren().get(1)).setViewport(new Rectangle2D(C.getX(),C.getY(),C.getWidthX(),C.getWidthY()));
        ((ImageView) pane.getChildren().get(2)).setX(backgroundRight.sizeX- C.getX());
        ((ImageView) pane.getChildren().get(2)).setVisible(false);
        if (C.getX()+ C.getWidthX() > backgroundLeft.sizeX ){
            ((ImageView) pane.getChildren().get(2)).setViewport(new Rectangle2D(0,C.getY(),C.getWidthX()-(backgroundRight.sizeX- C.getX()),C.getWidthY()));
            ((ImageView) pane.getChildren().get(2)).setVisible(true);
        }
        if (C.getX()>= backgroundLeft.sizeX){
            C.setX(C.getX()-backgroundLeft.sizeX);
        }
        if(numberOfLives.value == 3) {
            numberOfLives.getBackground().setViewport(new Rectangle2D(100, 5, 755, 200));
            ((ImageView) pane.getChildren().get(3)).setX(-300);
            ((ImageView) pane.getChildren().get(3)).setY(-80);
        }
        else if (numberOfLives.value == 2) {
            numberOfLives.getBackground().setViewport(new Rectangle2D(99, 244, 758, 220));
            ((ImageView) pane.getChildren().get(3)).setX(-300);
            ((ImageView) pane.getChildren().get(3)).setY(-80);
        }
        else if (numberOfLives.value == 1) {
            numberOfLives.getBackground().setViewport(new Rectangle2D(96, 460, 758, 217));
            ((ImageView) pane.getChildren().get(3)).setX(-300);
            ((ImageView) pane.getChildren().get(3)).setY(-80);
        }
        else {
            numberOfLives.getBackground().setViewport(new Rectangle2D(94, 681, 754, 221));
            ((ImageView) pane.getChildren().get(3)).setX(-300);
            ((ImageView) pane.getChildren().get(3)).setY(-80);
        }
    }
}
