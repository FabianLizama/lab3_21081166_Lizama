public class PixHex_21081166_LizamaFabian extends Pixel_21081166_LizamaFabian{
    /**
     * hexcode representa el color del pixel en formato hexadecimal, por ejemplo "a9ff00"
     */
    public String hexcode;
    /**
     * Método constructor de Pixbit
     * @param x coordenada x del pixel
     * @param y coordenada y del pixel
     * @param depth profundidad del pixel en el espacio
     * @param hexcode color del pixel en formato hexadecimal
     */
    public PixHex_21081166_LizamaFabian(int x, int y, int depth, String hexcode) {
        this.hexcode = hexcode;
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    /**
     * Selector del código hexadecimal del pixel
     * @return codigo hexadecimal
     */
    public String getHexcode() {
        return hexcode;
    }
    /**
     * Modificador del código hexadecimal del pixel
     * @param hexcode  codigo hexadecimal a cambiar
     */
    public void setHexcode(String hexcode) {
        this.hexcode = hexcode;
    }
    /**
     * Método que invierte el color rgb de un pixel
     */
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
