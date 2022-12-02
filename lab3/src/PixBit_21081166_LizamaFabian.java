
public class PixBit_21081166_LizamaFabian extends Pixel_21081166_LizamaFabian{
    public int bit;

    public PixBit_21081166_LizamaFabian(int x, int y, int depth, int bit) {
        this.bit = bit;
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getBit() {
        return bit;
    }
    public void setBit(int bit) {
        this.bit = bit;
    }
    //public boolean invertColorBit(){}

}
