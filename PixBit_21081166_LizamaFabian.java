/**
 * Clase herencia de Pixel que representa un pixbit
 */
public class PixBit_21081166_LizamaFabian extends Pixel_21081166_LizamaFabian{
    /**
     * bit representa el color del pixel que en este caso solo puede ser un bit 0 o 1
     */
    public int bit;
    /**
     * Método constructor de Pixbit
     * @param x coordenada x del pixel
     * @param y coordenada y del pixel
     * @param depth profundidad del pixel en el espacio
     * @param bit color del pixel (solo puede ser un bit 0 o 1)
     */
    public PixBit_21081166_LizamaFabian(int x, int y, int depth, int bit) {
        this.bit = bit;
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    /**
     * Selector del bit del pixel
     * @return el bit que representa el color del pixel
     */
    public int getBit() {
        return bit;
    }
    /**
     * Modificador del bit del pixel
     * @param bit el bit a modificar del pixel
     */
    public void setBit(int bit) {
        this.bit = bit;
    }
    //public boolean invertColorBit(){}
}