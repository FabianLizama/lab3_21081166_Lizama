import java.util.ArrayList;
public class Pixmap_21081166_LizamaFabian extends Image_21081166_LizamaFabian{

    public ArrayList<PixRGB_21081166_LizamaFabian> pixlist;
    public Pixmap_21081166_LizamaFabian(int width, int height, ArrayList<PixRGB_21081166_LizamaFabian> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
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
        Histogram histogram = this.histogram();
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
    public void changePixel(Object pixel) {
        PixRGB_21081166_LizamaFabian pixelIn = (PixRGB_21081166_LizamaFabian) pixel;
        for(int i=0;i<this.getPixlist().size();i++){
            PixRGB_21081166_LizamaFabian thisPix = this.pixlist.get(i);
            if((thisPix.getX()==pixelIn.getX())&&(thisPix.getY()==pixelIn.getY())){
                this.getPixlist().set(i, pixel);
            }
        }
    }

    @Override
    public void invertColorRGB() {

    }

    @Override
    public String imageToString(){
        StringBuilder outString = new StringBuilder("La imagen resultante es:\n");
        for(int y=0;y<this.getHeight();y++){
            for (int x=0; x<this.getWidth();x++){
                for(int i=0;i<this.getPixlist().size();i++){
                    PixRGB_21081166_LizamaFabian pixel = (PixRGB_21081166_LizamaFabian) this.getPixlist().get(i);
                    if(pixel.getX()==x && pixel.getY()==y){
                        String tempString = "(" + x + y + pixel.getRgb() + "(" + pixel.getDepth() + "))";
                        outString.append(tempString);
                    }
                    if(x != (this.getWidth()-1))
                        outString.append("\t");
                }
            }
            outString.append("\n");
        }
        return outString.toString();
    }
}

