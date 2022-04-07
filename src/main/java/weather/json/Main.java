package weather.json;

import com.google.gson.annotations.SerializedName;

public class Main {
    public double temp;
    double pressure;
    double humidity;
    @SerializedName("temp_min")
    public double tempMin;
    @SerializedName("temp_max")
    public double tempMax;
}
