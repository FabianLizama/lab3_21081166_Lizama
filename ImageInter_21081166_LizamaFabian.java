import java.util.ArrayList;
/**
 * Image será la entidad principal a la cual estará orientado todo el proyecto,
 * el TDA está representado por una clase que posee ancho, largo y una lista de pixeles con los siguientes métodos:
 */
public interface ImageInter_21081166_LizamaFabian {
    boolean isBitmap();
    boolean isPixmap();
    boolean isHexmap();
    boolean isCompressed();
    void flipH();
    void flipV();
    void crop(int x1, int y1, int x2, int y2);
    Histogram_21081166_LizamaFabian histogram();
    void rotate90();
    void compress();
    void changePixel(Pixel_21081166_LizamaFabian pixel);
    void invertColorRGB();
    String imageToString();
    ArrayList<Image_21081166_LizamaFabian> depthLayers();
}
