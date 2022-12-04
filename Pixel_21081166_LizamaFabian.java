/**
 * Clase abstracta que representa el TDA Pixel que compone las imagenes
 */
public abstract class Pixel_21081166_LizamaFabian {
    /**
     * x e y representan las coordenadas en el plano del pixel
     * depth representa la profundidad en el espacio del pixel
     */
    public int x;
    public int y;

    public int depth;
    /**
     * Selector de la coordenada x del pixel
     * @return coordenada x
     */
    public int getX() {
        return x;
    }
    /**
     * Modificador de la coordenada x del pixel
     * @param x coordenada x a modificar
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Selector de la coordenada y del pixel
     * @return coordenada y
     */
    public int getY() {
        return y;
    }
    /**
     * Modificador de la coordenada y del pixel
     * @param y coordenada y a modificar
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Selector de la profundidad del pixel
     * @return la profundidad
     */
    public int getDepth() {
        return depth;
    }
    /**
     * Método que invierte horizontalmente la coordenada x de un pixel
     * @param width el ancho de la imagen al cual pertenece el pixel
     */
    public void pixFlipH(int width){
        this.setX(Math.abs((this.getX() - (width - 1))));
    }
    /**
     * Método que invierte verticalmente la coordenada y de un pixel
     * @param height el largo de la imagen al cual pertenece el pixel
     */
    public void pixFlipV(int height){
        this.setY(Math.abs((this.getY() - (height - 1))));
    }
    /**
     * Método que rota en 90° las coordenadas del pixel
     * @param width el ancho de la imagen al cual pertenece el pixel
     */
    public void pixRotate90(int width){
        int x = this.getX();
        int y = this.getY();
        int newX = (y*-1)+(width-1);
        this.setX(newX);
        this.setY(x);
    }

}
