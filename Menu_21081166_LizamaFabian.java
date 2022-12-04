import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase Menu contiene el menú a mostrarse por consola para la manipulación del proyecto completo
 */
public class Menu_21081166_LizamaFabian {
    /**
     * imageMemory corresponde a la memoria del programa donde se manipularán las imágenes a trabajar
     */
    public static ArrayList imageMemory = new ArrayList<>();
    /**
     * Método que inicia el menú para la manipulación de imágenes
     */
    public static void startMenu() {
        ArrayList<PixBit_21081166_LizamaFabian> pixlist = new ArrayList<>();
        pixlist.add(new PixBit_21081166_LizamaFabian(0, 0, 9, 1));
        pixlist.add(new PixBit_21081166_LizamaFabian(1, 0, 8, 0));
        pixlist.add(new PixBit_21081166_LizamaFabian(0, 1, 7, 1));
        pixlist.add(new PixBit_21081166_LizamaFabian(1, 1, 6, 0));
        addImage(new Bitmap_21081166_LizamaFabian(2, 2, pixlist));
        boolean power = true;
        while (power) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija su opcion: ");
            System.out.println("1. Crear una imagen");
            System.out.println("2. Modificar una imagen");
            System.out.println("3. Visualizar una imagen");
            System.out.println("4. Salir");
            System.out.println("Introduzca su opcion: ");
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
                            ArrayList<PixBit_21081166_LizamaFabian> pixBitList = new ArrayList<>();
                            Bitmap_21081166_LizamaFabian imageBit = new Bitmap_21081166_LizamaFabian(width, length, pixBitList);
                            for (int x = 0; x < width; x++) {
                                for (int y = 0; y < length; y++) {
                                    System.out.println("Ingrese el bit del pixel de coordenadas (" + x + "," + y + "): ");
                                    int bit = sc.nextInt();
                                    System.out.println("Ingrese la profundidad del pixel de coordenadas (" + x + "," + y + "): ");
                                    int depth = sc.nextInt();
                                    imageBit.addPixBit(x, y, depth, bit);
                                }
                            }
                            addImage(imageBit);
                            System.out.println("Su imagen ha sido guardada como la Imagen " + (imageMemory.indexOf(imageBit) + 1));
                            String imageOut = imageBit.imageToString();
                            System.out.println(imageOut);
                            break;
                        case 2:
                            ArrayList<PixRGB_21081166_LizamaFabian> pixRGBList = new ArrayList<>();
                            Pixmap_21081166_LizamaFabian imageRGB = new Pixmap_21081166_LizamaFabian(width, length, pixRGBList);
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
                                    imageRGB.addPixRGB(x, y, depth, r, g, b);
                                }
                            }
                            addImage(imageRGB);
                            System.out.println("Su imagen ha sido guardada como la Imagen " + (imageMemory.indexOf(imageRGB) + 1));
                            System.out.println(imageRGB.imageToString());
                            break;
                        case 3:
                            ArrayList<PixHex_21081166_LizamaFabian> pixHexList = new ArrayList<>();
                            Hexmap_21081166_LizamaFabian imageHex = new Hexmap_21081166_LizamaFabian(width, length, pixHexList);
                            for (int x = 0; x < width; x++) {
                                for (int y = 0; y < length; y++) {
                                    System.out.println("Ingrese el codigo hexadecimal del pixel de coordenadas (" + x + "," + y + "): ");
                                    String hex = sc.next();
                                    System.out.println("Ingrese la profundidad del pixel de coordenadas (" + x + "," + y + "): ");
                                    int depth = sc.nextInt();
                                    imageHex.addPixHex(x, y, depth, hex);
                                }
                            }
                            addImage(imageHex);
                            System.out.println("Su imagen ha sido guardada como la Imagen " + (imageMemory.indexOf(imageHex) + 1));
                            System.out.println(imageHex.imageToString());
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el numero de la Imagen a modificar:");
                    int option = (sc.nextInt() - 1);
                    if (option>imageMemory.size()){
                        System.out.println("La imagen no existe, intente de nuevo");
                        break;
                    }
                    System.out.println("¿Qué operacion desea realizar?");
                    System.out.println("1. isBitmap");
                    System.out.println("2. isPixmap");
                    System.out.println("3. isHexmap");
                    System.out.println("4. isCompressed");
                    System.out.println("5. flipH");
                    System.out.println("6. flipV");
                    System.out.println("7. crop");
                    System.out.println("8. imgRgbtoHex (Solo permite Pixmaps)");
                    System.out.println("9. rotate90");
                    System.out.println("10. compress");
                    System.out.println("11. changePixel");
                    System.out.println("12. invertColorBit (Solo permite Bitmaps)");
                    System.out.println("13. invertColorRGB");
                    System.out.println("14. imageToString");
                    System.out.println("15. depthLayers");
                    int operation = sc.nextInt();
                    switch (operation) {
                        case 1:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isBitmap())
                                    System.out.println("La imagen es Bitmap");
                                else
                                    System.out.println("La imagen no es Bitmap");
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isBitmap())
                                    System.out.println("La imagen es Bitmap");
                                else
                                    System.out.println("La imagen no es Bitmap");
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isBitmap())
                                    System.out.println("La imagen es Bitmap");
                                else
                                    System.out.println("La imagen no es Bitmap");
                            }
                            break;
                        case 2:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isPixmap())
                                    System.out.println("La imagen es Pixmap");
                                else
                                    System.out.println("La imagen no es Pixmap");
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isPixmap())
                                    System.out.println("La imagen es Pixmap");
                                else
                                    System.out.println("La imagen no es Pixmap");
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isPixmap())
                                    System.out.println("La imagen es Pixmap");
                                else
                                    System.out.println("La imagen no es Pixmap");
                            }
                            break;
                        case 3:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isHexmap())
                                    System.out.println("La imagen es Hexmap");
                                else
                                    System.out.println("La imagen no es Hexmap");
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isHexmap())
                                    System.out.println("La imagen es Hexmap");
                                else
                                    System.out.println("La imagen no es Hexmap");
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isHexmap())
                                    System.out.println("La imagen es Hexmap");
                                else
                                    System.out.println("La imagen no es Hexmap");
                            }
                            break;
                        case 4:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isCompressed())
                                    System.out.println("La imagen esta comprimida");
                                else
                                    System.out.println("La imagen no esta comprimida");
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isCompressed())
                                    System.out.println("La imagen esta comprimida");
                                else
                                    System.out.println("La imagen no esta comprimida");
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                if (image.isCompressed())
                                    System.out.println("La imagen esta comprimida");
                                else
                                    System.out.println("La imagen no esta comprimida");
                            }
                            break;
                        case 5:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.flipH();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.flipH();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.flipH();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 6:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.flipV();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.flipV();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.flipV();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 7:
                            System.out.println("Ingrese la coordenada x1 a cortar la imagen: ");
                            int x1 = sc.nextInt();
                            System.out.println("Ingrese la coordenada y1 a cortar la imagen: ");
                            int y1 = sc.nextInt();
                            System.out.println("Ingrese la coordenada x2 a cortar la imagen: ");
                            int x2 = sc.nextInt();
                            System.out.println("Ingrese la coordenada y2 a cortar la imagen: ");
                            int y2 = sc.nextInt();
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.crop(x1, y1, x2, y2);
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.crop(x1, y1, x2, y2);
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.crop(x1, y1, x2, y2);
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 8:
                            if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.imgRGBToHex();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else {
                                System.out.println("La imagen ingresada no es Pixmap");
                            }
                            break;
                        case 9:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.rotate90();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.rotate90();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.rotate90();
                                System.out.println("Imagen modificada.");
                            }
                            break;
                        case 10:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.compress();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.compress();
                                System.out.println("Imagen modificada.");
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.compress();
                                System.out.println("Imagen modificada.");
                            }
                            break;
                        case 11:
                            System.out.println("Ingrese el pixel de entrada a modificar: ");
                            System.out.println("Ingrese la coordenada x: ");
                            int x = sc.nextInt();
                            System.out.println("Ingrese la coordenada y: ");
                            int y = sc.nextInt();
                            System.out.println("Ingrese la profundidad: ");
                            int d = sc.nextInt();
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                System.out.println("Ingrese el bit: ");
                                int bit = sc.nextInt();
                                PixBit_21081166_LizamaFabian pixel = new PixBit_21081166_LizamaFabian(x, y, d, bit);
                                image.changePixel(pixel);
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                System.out.println("Ingrese el valor de r: ");
                                int r = sc.nextInt();
                                System.out.println("Ingrese el valor de g: ");
                                int g = sc.nextInt();
                                System.out.println("Ingrese el valor de b: ");
                                int b = sc.nextInt();
                                PixRGB_21081166_LizamaFabian pixel = new PixRGB_21081166_LizamaFabian(x, y, d, r, g, b);
                                image.changePixel(pixel);
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                System.out.println("Ingrese el codigo hexadecimal de la forma 'ffffff': ");
                                String hex = sc.nextLine();
                                PixHex_21081166_LizamaFabian pixel = new PixHex_21081166_LizamaFabian(x, y, d, hex);
                                image.changePixel(pixel);
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 12:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.invertColorBit();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else {
                                System.out.println("La imagen solicitada no es Bitmap");
                            }
                            break;
                        case 13:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.invertColorRGB();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.invertColorRGB();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                image.invertColorRGB();
                                System.out.println("Imagen modificada: ");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 14:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                System.out.println("La imagen es la siguiente: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                System.out.println("La imagen es la siguiente: ");
                                System.out.println(image.imageToString());
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                System.out.println("La imagen es la siguiente: ");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 15:
                            if (imageMemory.get(option).getClass() == Bitmap_21081166_LizamaFabian.class) {
                                Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(option);
                                ArrayList<Bitmap_21081166_LizamaFabian> imagelist = image.depthLayers();
                                System.out.println("Imagen modificada, las imagenes creadas son las siguientes: ");
                                for (int i = 0; i < imagelist.size(); i++) {
                                    PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) imagelist.get(i).getPixlist().get(0);
                                    System.out.println("Imagen de profundidad " + pixel.getDepth() + ": ");
                                    System.out.println(imagelist.get(i).imageToString());
                                }
                            } else if (imageMemory.get(option).getClass() == Pixmap_21081166_LizamaFabian.class) {
                                Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(option);
                                ArrayList<Pixmap_21081166_LizamaFabian> imagelist = image.depthLayers();
                                System.out.println("Imagen modificada, las imagenes creadas son las siguientes: ");
                                for (int i = 0; i < imagelist.size(); i++) {
                                    PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) imagelist.get(i).getPixlist().get(0);
                                    System.out.println("Imagen de profundidad " + pixel.getDepth() + ": ");
                                    System.out.println(imagelist.get(i).imageToString());
                                }
                            } else if (imageMemory.get(option).getClass() == Hexmap_21081166_LizamaFabian.class) {
                                Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(option);
                                ArrayList<Hexmap_21081166_LizamaFabian> imagelist = image.depthLayers();
                                System.out.println("Imagen modificada, las imagenes creadas son las siguientes: ");
                                for (int i = 0; i < imagelist.size(); i++) {
                                    PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) imagelist.get(i).getPixlist().get(0);
                                    System.out.println("Imagen de profundidad " + pixel.getDepth() + ": ");
                                    System.out.println(imagelist.get(i).imageToString());
                                }
                            }
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Hay " + imageMemory.size() + " imagenes en la memoria ¿Que numero desea visualizar?");
                    int imageN = (sc.nextInt() - 1);
                    if (imageN>imageMemory.size()){
                        System.out.println("La imagen no existe, intente de nuevo");
                        break;
                    }
                    if (imageMemory.get(imageN).getClass() == Bitmap_21081166_LizamaFabian.class) {
                        Bitmap_21081166_LizamaFabian image = (Bitmap_21081166_LizamaFabian) imageMemory.get(imageN);
                        System.out.println(image.imageToString());
                    } else if (imageMemory.get(imageN).getClass() == Pixmap_21081166_LizamaFabian.class) {
                        Pixmap_21081166_LizamaFabian image = (Pixmap_21081166_LizamaFabian) imageMemory.get(imageN);
                        System.out.println(image.imageToString());
                    } else if (imageMemory.get(imageN).getClass() == Hexmap_21081166_LizamaFabian.class) {
                        Hexmap_21081166_LizamaFabian image = (Hexmap_21081166_LizamaFabian) imageMemory.get(imageN);
                        System.out.println(image.imageToString());
                    }
                    break;
                case 4:
                    power = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        }
    }
    /**
     * Método que añade una imagen a la memoria del programa
     * @param Image imagen a añadir a la memoria
     */
    public static void addImage (ImageInter_21081166_LizamaFabian Image){
        imageMemory.add(Image);
    }

}
