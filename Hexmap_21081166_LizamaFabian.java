import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Hexmap_21081166_LizamaFabian extends Image_21081166_LizamaFabian{
    String frequentColor;
    public void setFrequentColor(String frequentColor) {
        this.frequentColor = frequentColor;
    }

    public ArrayList<PixHex_21081166_LizamaFabian> pixlist;

    public ArrayList<PixHex_21081166_LizamaFabian> getPixlist(){
        return this.pixlist;
    }
    public Hexmap_21081166_LizamaFabian(int width, int height, ArrayList<PixHex_21081166_LizamaFabian> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
    }
    public void addPixHex(int x, int y, int depth, String hex){
        PixHex_21081166_LizamaFabian pixel = new PixHex_21081166_LizamaFabian(x, y, depth, hex);
        this.pixlist.add(pixel);
    }
    @Override
    public boolean isCompressed() {
        return !(this.getPixlist().size() == (this.getWidth() * this.getHeight()));
    }

    @Override
    public void flipH() {
        for(int i=0; i<this.getPixlist().size();i++){
            PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixFlipH(this.getWidth());
        }
    }

    @Override
    public void flipV() {
        for(int i=0; i<this.getPixlist().size();i++){
            PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixFlipV(this.getHeight());
        }
    }

    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        if(this.isPixmap()) {
            ArrayList<PixHex_21081166_LizamaFabian> newPixlist = new ArrayList<>();
            for (int i = 0; i < this.getPixlist().size(); i++) {
                PixHex_21081166_LizamaFabian actualPixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
                if ((actualPixel.getX() >= x1) && (actualPixel.getX() <= x2) && (actualPixel.getY() >= y1) && (actualPixel.getY() <= y2))
                    newPixlist.add(actualPixel);
            }
            this.pixlist=newPixlist;
            this.setWidth((x2 - x1) + 1);
            this.setHeight((y2 - y1) + 1);
        }
    }

    @Override
    public Histogram_21081166_LizamaFabian histogram(){
        Histogram_21081166_LizamaFabian histogram = new Histogram_21081166_LizamaFabian();
        for(int i=0;i<this.getPixlist().size();i++){
            PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
            String color = pixel.getHexcode();
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
            PixHex_21081166_LizamaFabian actualPix = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
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
        String color = (String) maxPair.get(1);
        this.setFrequentColor(color);
        for (int j=0; j<this.getPixlist().size(); j++){
            PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(j);
            if(Objects.equals(pixel.getHexcode(), color)){
                this.getPixlist().remove(pixel);
            }
        }
    }

    @Override
    public void changePixel(Pixel_21081166_LizamaFabian pixel) {
        PixHex_21081166_LizamaFabian pixelIn = (PixHex_21081166_LizamaFabian) pixel;
        for(int i=0;i<this.getPixlist().size();i++){
            PixHex_21081166_LizamaFabian thisPix = this.pixlist.get(i);
            if((thisPix.getX()==pixelIn.getX())&&(thisPix.getY()==pixelIn.getY())){
                this.getPixlist().set(i, (PixHex_21081166_LizamaFabian) pixel);
            }
        }
    }

    @Override
    public void invertColorRGB() {
        for(int i=0;i<this.getPixlist().size();i++){
            PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
            pixel.pixHexInvertColorRGB();
        }
    }

    @Override
    public String imageToString(){
        StringBuilder outString = new StringBuilder("La imagen resultante es:\n");
        for(int y=0;y<this.getHeight();y++){
            for (int x=0; x<this.getWidth();x++){
                for(int i=0;i<this.getPixlist().size();i++){
                    PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
                    if((pixel.getX()==x) && (pixel.getY()==y)){
                        String tempString = "("+pixel.getHexcode() + " (" + pixel.getDepth() + ")) ";
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
        ArrayList<Hexmap_21081166_LizamaFabian> imageList = new ArrayList<>();
        Stack<Integer> depthList = new Stack<>();
        for(int i=0;i<this.getPixlist().size();i++){
            PixHex_21081166_LizamaFabian pixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
            int d = pixel.getDepth();
            if(!(depthList.contains(d))){
                depthList.push(d);
            }
        }
        while (!(depthList.isEmpty())){
            int actualD = depthList.pop();
            ArrayList<PixHex_21081166_LizamaFabian> newPixList = new ArrayList<>();
            for(int i=0;i<this.getPixlist().size();i++){
                PixHex_21081166_LizamaFabian actualPixel = (PixHex_21081166_LizamaFabian) this.getPixlist().get(i);
                if(actualPixel.getDepth()==actualD){
                    newPixList.add(actualPixel);
                }
                else {
                    PixHex_21081166_LizamaFabian pix = new PixHex_21081166_LizamaFabian(actualPixel.getX(), actualPixel.getY(), actualD, "ffffff");
                    newPixList.add(pix);
                }
            }
            Hexmap_21081166_LizamaFabian image = new Hexmap_21081166_LizamaFabian(this.getWidth(), this.getHeight(), newPixList);
            imageList.add(image);
        }
        return imageList;
    }
}

