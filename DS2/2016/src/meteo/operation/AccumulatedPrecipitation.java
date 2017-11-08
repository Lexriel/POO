package meteo.operation;

import java.util.List;

import meteo.Operation;
import meteo.WeatherData;

/** computes accumulated precipitation between two dates
 * @author JC
 *
 */
public class AccumulatedPrecipitation implements Operation{

    private int startDay;
    private int endDay;
	
    public AccumulatedPrecipitation(int startDay, int endDay){
	this.startDay = startDay;
	this.endDay = endDay;
    }

    @Override
    public double process(List<WeatherData> dataList){
	double result = 0;
	for (WeatherData data : dataList){
	    if (data.getDay() >= this.startDay && data.getDay() <= this.endDay)
		result = result + data.getPrecipitation();
	}
	return result;
    }

    @Override
    public String getDescription(){
	return "cumulated precipitation between days "+ this.startDay + " and " + this.endDay;
    }
}
