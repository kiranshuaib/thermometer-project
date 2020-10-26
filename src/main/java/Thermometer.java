public class Thermometer {

    private double temp;
    private boolean freezing = false;
    private boolean boiling = false;
    private double fluctuation = 0.5;
    private double freezing_temp = 0;
    private double boiling_temp = 100.0;


    public double getFluctuation() {
        return fluctuation;
    }

    public void setFluctuation(double fluctuation) {
        this.fluctuation = fluctuation;
    }

    public double getFreezing_temp() {
        return freezing_temp;
    }

    public void setFreezing_temp(double freezing_temp) {
        this.freezing_temp = freezing_temp;
    }

    public double getBoiling_temp() {
        return boiling_temp;
    }

    public void setBoiling_temp(double boiling_temp) {
        this.boiling_temp = boiling_temp;
    }

    public Thermometer() {
    }

    public double getTemp() {
        return temp;
    }

    public double getTempF() {
        return tempCtoF(temp);
    }

    public void setTemp(double temp) {
        this.temp = temp;

    }

    public void setTempF(double temp) {
        this.temp = tempFtoC(temp);

    }

    public boolean isFreezing() {
        return freezing;
    }

    public void setFreezing(boolean freezing) {
        this.freezing = freezing;
    }

    public boolean isBoiling() {
        return boiling;
    }

    public void setBoiling(boolean boiling) {
        this.boiling = boiling;
    }



    public  double tempFtoC (double temp) {
        double tempC = ((temp - 32)*5)/9;
        double roundOff = Math.round(tempC*100)/100;
        return roundOff;
    }

    public  double tempCtoF (double temp) {
        double tempF = ((9*temp)/5)+32;

        return tempF;
    }

    public boolean has_freezing_threshold_reached(){
       if (temp <=  (getFreezing_temp()+getFluctuation())){
           setFreezing(true);
           return true;
        }
       else
       setFreezing(false);
       return false;
    }

    public boolean has_boiling_threshold_reached(){
        if (temp >= (getBoiling_temp()-getFluctuation())){
            setBoiling(true);
            return true;
        }
        else
            setBoiling(false);
        return false;
    }




}

