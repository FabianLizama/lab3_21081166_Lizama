import java.util.ArrayList;
import java.util.Stack;
//*

public class Bitmap_21081166_LizamaFabian extends Image_21081166_LizamaFabian{
    int frequentBit;
    public void setFrequentBit(int frequentBit) {
        this.frequentBit = frequentBit;
    }
    public ArrayList<PixBit_21081166_LizamaFabian> pixlist;
    public Bitmap_21081166_LizamaFabian(int width, int height, ArrayList<PixBit_21081166_LizamaFabian> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
    }

    public ArrayList<PixBit_21081166_LizamaFabian> getPixlist(){
        return this.pixlist;
    }

    public void addPixBit(int x, int y, int depth, int bit){
        PixBit_21081166_LizamaFabian pixel = new PixBit_21081166_LizamaFabian(x, y, depth, bit);
        this.pixlist.add(pixel);
    }
    @Override
    public boolean isCompressed() {
        return !(this.getPixlist().size() == (this.getWidth() * this.getHeight()));
    }

    @Override
    public void flipH() {
        for(int i=0; i<this.getPixlist().size();i++){
            PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixFlipH(this.getWidth());
        }
    }

    @Override
    public void flipV() {
        for(int i=0; i<this.getPixlist().size();i++){
            PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixFlipV(this.getHeight());
        }
    }

    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        if(this.isPixmap()) {
            ArrayList<PixBit_21081166_LizamaFabian> newPixlist = new ArrayList<>();
            for (int i = 0; i < this.getPixlist().size(); i++) {
                PixBit_21081166_LizamaFabian actualPixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
                if ((actualPixel.getX() >= x1) && (actualPixel.getX() <= x2) && (actualPixel.getY() >= y1) && (actualPixel.getY() <= y2))
                    newPixlist.add(actualPixel);
            }
            this.pixlist = newPixlist;
            this.setWidth((x2 - x1) + 1);
            this.setHeight((y2 - y1) + 1);
        }
    }



    @Override
    public Histogram_21081166_LizamaFabian histogram(){
        Histogram_21081166_LizamaFabian histogram = new Histogram_21081166_LizamaFabian();
        for(int i=0;i<this.getPixlist().size();i++){
            PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
            int color = pixel.getBit();
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
            PixBit_21081166_LizamaFabian actualPix = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
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
        int color = (int) maxPair.get(1);
        this.setFrequentBit(color);
        for (int j=0; j<this.getPixlist().size(); j++){
            PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(j);
            if(pixel.getBit()==color){
                this.getPixlist().remove(pixel);
            }
        }
    }
    @Override
    public void changePixel(Pixel_21081166_LizamaFabian pixel) {
        PixBit_21081166_LizamaFabian pixelIn = (PixBit_21081166_LizamaFabian) pixel;
        for(int i=0;i<this.getPixlist().size();i++){
            PixBit_21081166_LizamaFabian thisPix = this.pixlist.get(i);
            if((thisPix.getX()==pixelIn.getX())&&(thisPix.getY()==pixelIn.getY())){
                this.getPixlist().set(i, (PixBit_21081166_LizamaFabian) pixel);
            }
        }
    }

    public void invertColorBit(){
        for(int i=0;i<this.getPixlist().size();i++){
            PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
            if(pixel.getBit()==1)
                pixel.setBit(0);
            else
                pixel.setBit(1);
        }
    }
    @Override
    public void invertColorRGB() {
        this.invertColorBit();
    }
    @Override
    public String imageToString(){
        StringBuilder outString = new StringBuilder("La imagen resultante es:\n");
        for(int y=0;y<this.getHeight();y++){
            for (int x=0; x<this.getWidth();x++){
                for(int i=0;i<this.getPixlist().size();i++){
                    PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
                    if((pixel.getX()==x) && (pixel.getY()==y)){
                        String tempString = "("+pixel.getBit() + " (" + pixel.getDepth() + ")) ";
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
        ArrayList<Bitmap_21081166_LizamaFabian> imageList = new ArrayList<>();
        Stack<Integer> depthList = new Stack<>();
        for(int i=0;i<this.getPixlist().size();i++){
            PixBit_21081166_LizamaFabian pixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
            int d = pixel.getDepth();
            if(!(depthList.contains(d))){
                depthList.push(d);
            }
        }
        while (!(depthList.isEmpty())){
            int actualD = depthList.pop();
            ArrayList<PixBit_21081166_LizamaFabian> newPixList = new ArrayList<>();
            for(int i=0;i<this.getPixlist().size();i++){
                PixBit_21081166_LizamaFabian actualPixel = (PixBit_21081166_LizamaFabian) this.getPixlist().get(i);
                if(actualPixel.getDepth()==actualD){
                    newPixList.add(actualPixel);
                }
                else {
                    PixBit_21081166_LizamaFabian pix = new PixBit_21081166_LizamaFabian(actualPixel.getX(), actualPixel.getY(), actualD, 1);
                    newPixList.add(pix);
                }
            }
            Bitmap_21081166_LizamaFabian image = new Bitmap_21081166_LizamaFabian(this.getWidth(), this.getHeight(), newPixList);
            imageList.add(image);
        }
        return imageList;
    }
}
