import java.util.ArrayList;

public abstract class Image_21081166_LizamaFabian implements ImageInter_21081166_LizamaFabian {
    public int width;
    public int height;

    public ArrayList<Object> pixlist = new ArrayList<>();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Object> getPixlist(){
        return this.pixlist;
    }

    public void setPixlist(ArrayList<Object> pixlist){
        this.pixlist = pixlist;
    }

    public boolean isBitmap() {
        ArrayList<PixBit_21081166_LizamaFabian> pixlist = new ArrayList<>();
        Bitmap_21081166_LizamaFabian exampleBitmap = new Bitmap_21081166_LizamaFabian(0,0,pixlist);
        return this.getClass() == exampleBitmap.getClass();

    }

    public boolean isPixmap() {
        ArrayList<PixRGB_21081166_LizamaFabian> pixlist = new ArrayList<>();
        Pixmap_21081166_LizamaFabian examplePixmap = new Pixmap_21081166_LizamaFabian(0,0,pixlist);
        return this.getClass() == examplePixmap.getClass();
    }

    public boolean isHexmap() {
        ArrayList<PixHex_21081166_LizamaFabian> pixlist = new ArrayList<>();
        Hexmap_21081166_LizamaFabian exampleHexmap = new Hexmap_21081166_LizamaFabian(0,0,pixlist);
        return this.getClass() == exampleHexmap.getClass();
    }

    public boolean isCompressed() {
        return this.getPixlist().size() == (this.getWidth() * this.getHeight());
    }

    public abstract void flipH();

    public abstract void flipV();

    public void crop(int x1, int y1, int x2, int y2) {
        if(this.isPixmap()) {
            ArrayList<Object> newPixlist = new ArrayList<>();
            for (int i = 0; i < this.getPixlist().size(); i++) {
                PixBit_21081166_LizamaFabian actualPixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
                if ((actualPixel.getX() >= x1) && (actualPixel.getX() <= x2) && (actualPixel.getY() >= y1) && (actualPixel.getY() <= y2))
                    newPixlist.add(actualPixel);
            }
            this.setPixlist(newPixlist);
            this.setWidth((x2 - x1) + 1);
            this.setHeight((y2 - y1) + 1);
        }
    }

    public void imgRGBToHex() {
        ArrayList<Object> newPixlist = new ArrayList<>();
        for (int i = 0; i < getPixlist().size(); i++) {
            PixRGB_21081166_LizamaFabian pixrgb = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            String r = Integer.toHexString(pixrgb.getRgb().get(0));
            String g = Integer.toHexString(pixrgb.getRgb().get(1));
            String b = Integer.toHexString(pixrgb.getRgb().get(2));
            String hexcode = r.concat(g).concat(b);
            PixHex_21081166_LizamaFabian pixhex = new PixHex_21081166_LizamaFabian(pixrgb.getX(), pixrgb.getY(), pixrgb.getDepth(), hexcode);
            newPixlist.add(pixhex);
        }
        setPixlist(newPixlist);
    }

    public Histogram histogram() {
        Histogram histogram = new Histogram();
        if(this.isBitmap()){
            for(int i=0;i<this.getPixlist().size();i++){
                PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
                int color = pixel.getBit();
                histogram.addColor(color);
            }
        } else if (this.isPixmap()) {
            for (int i = 0; i < this.getPixlist().size(); i++) {
                PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
                ArrayList<Integer> color = pixel.getRgb();
                histogram.addColor(color);
            }
        } else if (this.isHexmap()) {
            for(int i=0;i<this.getPixlist().size();i++){
                PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
                String color = pixel.getHexcode();
                histogram.addColor(color);
            }
        }
        return histogram;
    }

    public abstract void rotate90();
    public abstract void compress();
    public abstract void changePixel(Object pixel);
    public abstract void invertColorRGB();
    public abstract String imageToString();

    public ArrayList<Object> depthLayers() {
        return null;
    }

    public void decompress() {
    }
}
