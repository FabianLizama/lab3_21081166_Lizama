
public abstract class Pixel_21081166_LizamaFabian {
    public int x;
    public int y;

    public int depth;

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

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void pixFlipH(int width){
        this.setX(Math.abs((this.getX() - (width - 1))));
    }

    public void pixFlipV(int height){
        this.setY(Math.abs((this.getY() - (height - 1))));
    }
    public void pixRotate90(int width){
        int x = this.getX();
        int y = this.getY();
        int newX = (y*-1)+(width-1);
        this.setX(newX);
        this.setY(x);
    }

}
