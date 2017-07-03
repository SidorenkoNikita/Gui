import java.io.IOException;

/**
 * Created by Nikita on 03.07.2017.
 */
public class Cell {
    private int status;
    final static int sizeCell = 40;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeStatus() throws Exception{
        if (!(this.status == 1)){
            switch (this.status){
                case 0:
                    this.status = 2;
                    break;
                case 2:
                    this.status = 3;
                    break;
                case 4:
                    this.status = 5;
                    break;
                default:
                    throw new IOException("Invalid cell status");
            }
        }
        else{
            this.status = 6;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
