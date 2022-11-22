import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {

    protected static double x;

    protected static double y;
    protected static Image spriteSheet;

    protected static ImageView sprite;

    protected Integer state;

    protected static Integer index;

    protected static Integer maxIndex;

    protected static long durationFrames;

    protected Integer sizeWindow;

    protected static Integer offsetFrame;

    protected static Integer countFrame;

    protected static Integer maxFrame;

    public AnimatedThing (String fileName, Integer x, Integer y,Integer state){
        countFrame =4;
        maxFrame = 4;
        durationFrames = 41666666;
        offsetFrame = 85;
        state = 0;
        maxIndex = 5;
        index = 0;
        spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0,0,85,100));
        sprite.setX(x);
        sprite.setY(y);

    }

    public ImageView getSprite() {
        return sprite;
    }


    public static void update(long time) {
        if (countFrame == maxFrame){
            Hero.sprite.setViewport(new Rectangle2D((Hero.index)*Hero.offsetFrame,0,85,100));
            if(Hero.index == Hero.maxIndex){
                Hero.index = 0;
            }
            else{
                Hero.index+=1;
            }
            countFrame = 0;
        }
        else {
            countFrame+=1;
        }



    }
}
