import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StaticThing {
    protected Integer sizeX;
    protected Integer sizeY;
    private final ImageView background;

    protected Integer value;

    protected Image imageBackground;



    public StaticThing(Integer sizeX, Integer sizeY,  Integer X,Integer Y,String fileName,Integer value) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.imageBackground = new Image(fileName);
        this.background = new ImageView(imageBackground);
        this.background.setX(X);
        this.background.setY(Y);
        this.value = value;
    }

    public ImageView getBackground() {
        return background;
    }

    public Image getImageBackground() {
        return imageBackground;
    }
}
