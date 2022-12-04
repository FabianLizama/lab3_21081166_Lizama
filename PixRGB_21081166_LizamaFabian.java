import java.util.ArrayList;

public class PixRGB_21081166_LizamaFabian extends Pixel_21081166_LizamaFabian{
    public ArrayList<Integer> rgb = new ArrayList<>();

    public PixRGB_21081166_LizamaFabian(int x, int y, int depth, int r, int g, int b) {
        this.rgb.add(r);
        this.rgb.add(g);
        this.rgb.add(b);
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    public ArrayList<Integer> getRgb() {
        return rgb;
    }

    public void setRgb(ArrayList<Integer> rgb) {
        this.rgb = rgb;
    }
    public void pixRGBInvertColorRGB(){
        int r = this.getRgb().get(0);
        int g = this.getRgb().get(1);
        int b = this.getRgb().get(2);
        ArrayList<Integer> newRGB = new ArrayList<>();
        newRGB.add(255-r);
        newRGB.add(255-g);
        newRGB.add(255-b);
        this.setRgb(newRGB);
    }
}
