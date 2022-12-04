import java.util.ArrayList;
import java.util.Stack;

public class Pixmap_21081166_LizamaFabian extends Image_21081166_LizamaFabian{

    public ArrayList<PixRGB_21081166_LizamaFabian> pixlist;
    public Pixmap_21081166_LizamaFabian(int width, int height, ArrayList<PixRGB_21081166_LizamaFabian> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
    }

    public ArrayList<PixRGB_21081166_LizamaFabian> getPixlist(){
        return this.pixlist;
    }

    public void addPixRGB(int x, int y, int depth, int r, int g, int b){
        PixRGB_21081166_LizamaFabian pixel = new PixRGB_21081166_LizamaFabian(x, y, depth, r, g, b);
        this.pixlist.add(pixel);
    }
    @Override
    public boolean isCompressed() {
        return !(this.getPixlist().size() == (this.getWidth() * this.getHeight()));
    }

    @Override
    public void flipH() {
        for(int i=0; i<this.getPixlist().size();i++){
            PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixFlipH(this.getWidth());
        }
    }

    @Override
    public void flipV() {
        for(int i=0; i<this.getPixlist().size();i++){
            PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixFlipV(this.getHeight());
        }
    }

    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        if(this.isPixmap()) {
            ArrayList<PixRGB_21081166_LizamaFabian> newPixlist = new ArrayList<>();
            for (int i = 0; i < this.getPixlist().size(); i++) {
                PixRGB_21081166_LizamaFabian actualPixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
                if ((actualPixel.getX() >= x1) && (actualPixel.getX() <= x2) && (actualPixel.getY() >= y1) && (actualPixel.getY() <= y2))
                    newPixlist.add(actualPixel);
            }
            this.pixlist = newPixlist;
            this.setWidth((x2 - x1) + 1);
            this.setHeight((y2 - y1) + 1);
        }
    }

    public void imgRGBToHex(){
            ArrayList<Pixel_21081166_LizamaFabian> newPixlist = new ArrayList<>();
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
    @Override
    public Histogram_21081166_LizamaFabian histogram(){
        Histogram_21081166_LizamaFabian histogram = new Histogram_21081166_LizamaFabian();
        for (int i = 0; i < this.getPixlist().size(); i++) {
            PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            ArrayList<Integer> color = pixel.getRgb();
            histogram.addColor(color);
        }
        return histogram;
    }

    @Override
    public void rotate90() {
        int width = this.getWidth();
        this.setWidth(this.getHeight());
        this.setHeight(width);

        for(int i=0;i<this.getPixlist().size();i++) {
            PixRGB_21081166_LizamaFabian actualPix = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            actualPix.pixRotate90(width);
        }
    }
    @Override
    public void compress() {
        Histogram_21081166_LizamaFabian histogram = this.histogram();
        ArrayList<Object> maxPair = new ArrayList<>();
        maxPair.add(0);
        int maxFrequency = (int) maxPair.get(0);
        for(int i=0; i<histogram.getHistogram().size();i++){
            ArrayList<Object> pair = (ArrayList<Object>) histogram.getHistogram().get(i);
            int frequency = (int) pair.get(0);
            if(frequency>maxFrequency){
                maxPair = pair;
                maxFrequency = frequency;
            }
        }
        ArrayList<Integer> color = (ArrayList<Integer>) maxPair.get(1);
        for (int j=0; j<this.getPixlist().size(); j++){
            PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(j);
            if(color == pixel.getRgb()){
                this.getPixlist().remove(pixel);
            }
        }
    }
    @Override
    public void changePixel(Pixel_21081166_LizamaFabian pixel) {
        PixRGB_21081166_LizamaFabian pixelIn = (PixRGB_21081166_LizamaFabian) pixel;
        for(int i=0;i<this.getPixlist().size();i++){
            PixRGB_21081166_LizamaFabian thisPix = this.pixlist.get(i);
            if((thisPix.getX()==pixelIn.getX())&&(thisPix.getY()==pixelIn.getY())){
                this.getPixlist().set(i, (PixRGB_21081166_LizamaFabian) pixel);
            }
        }
    }

    @Override
    public void invertColorRGB() {
        for(int i=0;i<this.getPixlist().size();i++){
            PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixRGBInvertColorRGB();
        }
    }

    @Override
    public String imageToString(){
        StringBuilder outString = new StringBuilder("La imagen resultante es:\n");
        for(int y=0;y<this.getHeight();y++){
            for (int x=0; x<this.getWidth();x++){
                for(int i=0;i<this.getPixlist().size();i++){
                    PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
                    if((pixel.getX()==x) && (pixel.getY()==y)){
                        String tempString = "("+pixel.getRgb() + " (" + pixel.getDepth() + ")) ";
                        outString.append(tempString);
                    }
                }
            }
            outString.append("\n");
        }
        return outString.toString();
    }

    @Override
    public ArrayList depthLayers() {
        ArrayList<Pixmap_21081166_LizamaFabian> imageList = new ArrayList<>();
        Stack<Integer> depthList = new Stack<>();
        for(int i=0;i<this.getPixlist().size();i++){
            PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
            int d = pixel.getDepth();
            if(!(depthList.contains(d))){
                depthList.push(d);
            }
        }
        while (!(depthList.isEmpty())){
            int actualD = depthList.pop();
            ArrayList<PixRGB_21081166_LizamaFabian> newPixList = new ArrayList<>();
            for(int i=0;i<this.getPixlist().size();i++){
                PixRGB_21081166_LizamaFabian actualPixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
                if(actualPixel.getDepth()==actualD){
                    newPixList.add(actualPixel);
                }
                else {
                    PixRGB_21081166_LizamaFabian pix = new PixRGB_21081166_LizamaFabian(actualPixel.getX(), actualPixel.getY(), actualD, 255, 255, 255);
                    newPixList.add(pix);
                }
            }
            Pixmap_21081166_LizamaFabian image = new Pixmap_21081166_LizamaFabian(this.getWidth(), this.getHeight(), newPixList);
            imageList.add(image);
        }
        return imageList;
    }

}

