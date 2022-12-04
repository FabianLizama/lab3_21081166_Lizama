import java.util.ArrayList;

public class PixRGB_21081166_LizamaFabian extends Pixel_21081166_LizamaFabian{
    /**
     * rgb es una lista que contiene la cantidad de cada canal r, g o b respectivamente
     */
    public ArrayList<Integer> rgb = new ArrayList<>();
    /**
     * Método constructor de Pixbit
     * @param x coordenada x del pixel
     * @param y coordenada y del pixel
     * @param depth profundidad del pixel en el espacio
     * @param r cantidad de rojo que tiene el pixel
     * @param g cantidad de verde que tiene el pixel
     * @param b cantidad de azul que tiene el pixel
     */
    public PixRGB_21081166_LizamaFabian(int x, int y, int depth, int r, int g, int b) {
        this.rgb.add(r);
        this.rgb.add(g);
        this.rgb.add(b);
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    /**
     * Selector del color del pixel
     * @return lista rgb con la información del color
     */
    public ArrayList<Integer> getRgb() {
        return rgb;
    }
    /**
     * Modificador del color del pixel
     * @param rgb lista rgb con la información del color
     */
    public void setRgb(ArrayList<Integer> rgb) {
        this.rgb = rgb;
    }
    /**
     * Método que invierte el color rgb de un pixel
     */
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
