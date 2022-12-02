import java.util.ArrayList;

public interface ImageInter_21081166_LizamaFabian {
    boolean isBitmap();
    boolean isPixmap();
    boolean isHexmap();
    boolean isCompressed();
    void flipH();
    void flipV();
    void crop(int x1, int y1, int x2, int y2);
    void imgRGBToHex();
    Histogram histogram();
    void rotate90();
    void compress();
    void changePixel(Object pixel);
    void invertColorRGB();
    String imageToString();
    ArrayList<Object> depthLayers();
    void decompress();
}
