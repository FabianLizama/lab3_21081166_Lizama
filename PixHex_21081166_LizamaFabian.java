public class PixHex_21081166_LizamaFabian extends Pixel_21081166_LizamaFabian{
    public String hexcode;

    public PixHex_21081166_LizamaFabian(int x, int y, int depth, String hexcode) {
        this.hexcode = hexcode;
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public String getHexcode() {
        return hexcode;
    }

    public void setHexcode(String hexcode) {
        this.hexcode = hexcode;
    }
    public void pixHexInvertColorRGB() {
        int r = Integer.parseInt(this.getHexcode().substring(0,2),16);
        int g = Integer.parseInt(this.getHexcode().substring(2,4),16);
        int b = Integer.parseInt(this.getHexcode().substring(4,6),16);
        String newR = Integer.toHexString(255-r);
        String newG = Integer.toHexString(255-g);
        String newB = Integer.toHexString(255-b);
        this.setHexcode(newR+newG+newB);
    }
}
