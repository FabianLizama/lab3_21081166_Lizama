import java.util.ArrayList;
/**
 * Clase abstracta de TDA Image que deriva en Bitmap, Pixmap y Hexmap, los métodos serán explicados en este código.
 */
public abstract class Image_21081166_LizamaFabian implements ImageInter_21081166_LizamaFabian {
    /**
     * los parámetros width y lenght representan el ancho y el largo de la imagen, a su vez pixlist es un Arraylist que
     * contiene la lista de pixeles que posee la imagen:
     */
    int width;
    int height;
    public ArrayList<Pixel_21081166_LizamaFabian> pixlist = new ArrayList<>();

    /**
     * Selector del ancho
     * @return el ancho de la imagen
     */
    public int getWidth() {
        return width;
    }
    /**
     * Modificador del ancho de la imagen
     * @param width ancho a modificar
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * Selector del largo
     * @return largo de la imagen
     */
    public int getHeight() {
        return height;
    }
    /**
     * Modificador del largo de la imagen
     * @param height largo a modificar
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * Modificador de la lista de pixeles de la imagen
     * @param pixlist lista de pixeles a modificar
     */
    public void setPixlist(ArrayList<Pixel_21081166_LizamaFabian> pixlist){
        this.pixlist = pixlist;
    }
    /**
     * Método de pertenencia de la imagen
     * @return boolean que representa si la imagen es de tipo Bitmap
     */
    public boolean isBitmap() {
        return this.getClass() == Bitmap_21081166_LizamaFabian.class;

    }
    /**
     * Método de pertenencia de la imagen
     * @return boolean que representa si la imagen es de tipo Pixmap
     */
    public boolean isPixmap() {
        return this.getClass() == Pixmap_21081166_LizamaFabian.class;
    }
    /**
     * Método de pertenencia de la imagen
     * @return boolean que representa si la imagen es de tipo Hexmap
     */
    public boolean isHexmap() {
        return this.getClass() == Hexmap_21081166_LizamaFabian.class;
    }
    /**
     * Método de pertenencia de la imagen
     * @return boolean que representa si la imagen está comprimida o no
     */
    public abstract boolean isCompressed();
    /**
     * Método abstracto que modifica la imagen voltenado horizontalmente todos sus pixeles
     */
    public abstract void flipH();
    /**
     * Método abstracto que modifica la imagen voltenado verticalmente todos sus pixeles
     */
    public abstract void flipV();
    /**
     * Método abstracto que recorta la imagen en el cuadrante ingresado
     * @param x1 coordenada x del punto 1 del cuadrante a recortar
     * @param y1 coordenada y del punto 1 del cuadrante a recortar
     * @param x2 coordenada x del punto 2 del cuadrante a recortar
     * @param y2 coordenada y del punto 2 del cuadrante a recortar
     */
    public abstract void crop(int x1, int y1, int x2, int y2);
    /**
     * Método abstracto que genera una Histograma para la imagen solicitada
     * @return objeto Histogram que tiene la frecuencia de los colores presentes en la imagen
     */
    public abstract Histogram_21081166_LizamaFabian histogram();
    /**
     * Método abstracto que rota la imagen en 90° rotando todos sus pixeles
     */
    public abstract void rotate90();
    /**
     * Método abstracto que comprime la imagen eliminando sus pixeles con el color más frecuente
     */
    public abstract void compress();
    /**
     * Método abstracto que modifica la imagen cambiando el pixel entregado por el que tiene las mismas coordenadas en
     * la imagen
     * @param pixel es una pixel de cualquier tipo (pixit, pixrgb o pixhex)
     */
    public abstract void changePixel(Pixel_21081166_LizamaFabian pixel);
    /**
     * Método abstracto que modifica la imagen invirtiendo simetricamente todos los colores de sus pixeles
     */
    public abstract void invertColorRGB();
    /**
     * Método abstracto que convierte la imagen en un String para facilitar su visualización por consola
     * @return un string con la imagen en un formato adecuado para su impresión por consola
     */
    public abstract String imageToString();
    /**
     * Método abstracto que recorta la imagen por sus distintas profundidades
     * @return una lista con las imagenes resultantes del recorte por profundidades
     */
    public abstract ArrayList depthLayers();
}
