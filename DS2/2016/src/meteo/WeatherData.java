package meteo;

public class WeatherData{

    private final double tMin;
    private final double tMax;
    private final double precipitation;
    private final int day;
	
    public WeatherData(int day, double tMin, double tMax, double precipitation){
	this.day = day;
	this.tMin = tMin;
	this.tMax = tMax;
	this.precipitation = precipitation;
    }

    public double getTMin(){
	return this.tMin;
    }

    public double getTMax(){
	return this.tMax;
    }

    public double getPrecipitation(){
	return this.precipitation;
    }

    public int getDay(){
	return this.day;
    }
}
