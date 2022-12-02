import java.util.ArrayList;
import java.util.Scanner;
// Clase del menú interactivo por consola
public class Menu_21081166_LizamaFabian {
    public static ArrayList<Object> imageMemory = new ArrayList<>();

    public static void startMenu() {
        boolean power = true;
        while (power) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija su opción: ");
            System.out.println("1. Crear una imagen");
            System.out.println("2. Modificar una imagen");
            System.out.println("3. Visualizar una imagen");
            System.out.println("4. Salir");
            System.out.println("Introduzca su opción: ");
            int menuOption = sc.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.println("Elija el tipo de imagen a crear: ");
                    System.out.println("1. Bitmap");
                    System.out.println("2. Pixmap");
                    System.out.println("3. Hexmap");
                    int imageType = sc.nextInt();
                    System.out.println("Ingrese el Ancho de la imagen a crear: ");
                    int width = sc.nextInt();
                    System.out.println("Ingrese el Largo de la imagen a crear: ");
                    int length = sc.nextInt();
                    switch (imageType) {
                        case 1:
                            ArrayList pixBitList = new ArrayList();
                            for (int x = 0; x < width; x++) {
                                for (int y = 0; y < length; y++) {
                                    System.out.println("Ingrese el bit del pixel de coordenadas (" + x + "," + y + "): ");
                                    int bit = sc.nextInt();
                                    System.out.println("Ingrese la profundidad del pixel de coordenadas (" + x + "," + y + "): ");
                                    int depth = sc.nextInt();
                                    pixBitList.add(new PixBit_21081166_LizamaFabian(x, y, depth, bit));
                                }
                            }
                            Bitmap_21081166_LizamaFabian imageBit = new Bitmap_21081166_LizamaFabian(width, length, pixBitList);
                            addImage(imageBit);
                            System.out.println("Su imagen ha sido guardada como la Imagen " + (imageMemory.indexOf(imageBit) + 1));
                            break;
                        case 2:
                            ArrayList pixRGBList = new ArrayList();
                            for (int x = 0; x < width; x++) {
                                for (int y = 0; y < length; y++) {
                                    System.out.println("Ingrese el canal R del pixel de coordenadas (" + x + "," + y + "): ");
                                    int r = sc.nextInt();
                                    System.out.println("Ingrese el canal G del pixel de coordenadas (" + x + "," + y + "): ");
                                    int g = sc.nextInt();
                                    System.out.println("Ingrese el canal B del pixel de coordenadas (" + x + "," + y + "): ");
                                    int b = sc.nextInt();
                                    System.out.println("Ingrese la profundidad del pixel de coordenadas (" + x + "," + y + "): ");
                                    int depth = sc.nextInt();
                                    pixRGBList.add(new PixRGB_21081166_LizamaFabian(x, y, depth, r, g, b));
                                }
                            }
                            Pixmap_21081166_LizamaFabian imageRGB = new Pixmap_21081166_LizamaFabian(width, length, pixRGBList);
                            addImage(imageRGB);
                            System.out.println("Su imagen ha sido guardada como la Imagen " + (imageMemory.indexOf(imageRGB) + 1));
                            break;
                        case 3:
                            ArrayList pixHexList = new ArrayList();
                            for (int x = 0; x < width; x++) {
                                for (int y = 0; y < length; y++) {
                                    System.out.println("Ingrese el código hexadecimal del pixel de coordenadas (" + x + "," + y + "): ");
                                    String hex = sc.nextLine();
                                    System.out.println("Ingrese la profundidad del pixel de coordenadas (" + x + "," + y + "): ");
                                    int depth = sc.nextInt();
                                    pixHexList.add(new PixHex_21081166_LizamaFabian(x, y, depth, hex));
                                }
                            }
                            Hexmap_21081166_LizamaFabian imageHex = new Hexmap_21081166_LizamaFabian(width, length, pixHexList);
                            addImage(imageHex);
                            System.out.println("Su imagen ha sido guardada como la Imagen " + (imageMemory.indexOf(imageHex) + 1));
                            break;

                        case 4:
                            power = false;
                            break;
                    }
            }
        }
    }
    public static void addImage (ImageInter_21081166_LizamaFabian Image){
        imageMemory.add(Image);
    }

}
