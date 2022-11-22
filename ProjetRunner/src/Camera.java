import java.util.IllegalFormatWidthException;

public class Camera {

    private double X;
    private final double Y;

    private final Integer widthX;

    private final Integer widthY;
    public Camera(Integer x, Integer y,Integer widthX,Integer widthY) {
        this.X = x;
        this.Y = y;
        this.widthX= widthX;
        this.widthY=widthY;

    }
    public double getX() {

        return X;
    }

    public double getY() {

        return Y;
    }

    public Integer getWidthX() {
        return widthX;
    }

    public Integer getWidthY() {
        return widthY;
    }

    public void setX(double x) {
        X = x;
    }

    @Override
    public String toString(){
        return "("+this.X+","+this.Y+")";
    }


    public void update(long time) {
    }
}
