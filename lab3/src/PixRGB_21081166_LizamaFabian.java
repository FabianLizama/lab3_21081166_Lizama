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
}
