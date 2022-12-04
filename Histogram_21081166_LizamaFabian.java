import java.util.ArrayList;
public class Histogram_21081166_LizamaFabian {
    public ArrayList<Object> histogram;

    public Histogram_21081166_LizamaFabian() {
        this.histogram = new ArrayList<>();
    }

    public ArrayList<Object> getHistogram() {
        return histogram;
    }

    public void setHistogram(ArrayList<Object> histogram) {
        this.histogram = histogram;
    }

    public void addColor(Object color){
        if(this.getHistogram().isEmpty()){
            ArrayList<Object> pair = new ArrayList<>();
            pair.add(1);
            pair.add(color);
            ArrayList<Object> hist = new ArrayList<>();
            hist.add(pair);
            this.setHistogram(hist);
        }
        else {
            int position = 0;
            boolean exists = false;
            for (int i=0; i<this.getHistogram().size();i++){
                ArrayList<Object> pair = (ArrayList<Object>) this.getHistogram().get(i);
                if(pair.get(1)==color){
                    exists = true;
                    position = i;
                }
            }
            if (exists){
                ArrayList<Object> pair = (ArrayList<Object>) this.getHistogram().get(position);
                int frequency = (int) pair.get(0);
                pair.set(0, (frequency+1));
            }
            else {
                ArrayList<Object> pair = new ArrayList<>();
                pair.add(1);
                pair.add(color);
                this.getHistogram().add(pair);
            }
        }
    }


}
