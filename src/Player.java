/**
 * Created by Nikita on 03.07.2017.
 */
public class Player {
    private Cell cell;
    public int getY() {
        int result = this.cell.getY();
        return result;
    }
    public int getX() {
        int result = this.cell.getX();
        return result;
    }
    public void left(){
        if(!(cell.getStatus() == 6)) {
            this.cell.setX(this.cell.getX() - 1);
        }
    }
    public void right(){
        if(!(cell.getStatus() == 6)) {
            this.cell.setX(this.cell.getX() + 1);
        }
    }
    public void up(){
        if(!(cell.getStatus() == 6)) {
            this.cell.setX(this.cell.getY() - 1);
        }
    }
    public void down(){
        if(!(cell.getStatus() == 6)) {
            this.cell.setX(this.cell.getY() +1);
        }
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
