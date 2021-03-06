package meteo;

import java.util.*;

import meteo.operation.MinTMinOperation;

public class WeatherMain{

    public static void main(String[] args){
	WeatherAnalysis analysis = new WeatherAnalysis();
	Map<WeatherStation,List<WeatherData>> dailyData = new HashMap<WeatherStation,List<WeatherData>>();
	// ... dailyData is filled with values...
		
	analysis.receiveDailyData(dailyData);
		
	WeatherStation station1 = new WeatherStation("1234", "SomeWhereCity");
		
	try{
	    Operation operation = new MinTMinOperation();
	    double result = analysis.processData(station1, operation);
	    System.out.println("the result of " + operation.getDescription() + " for " + station1 + " is " + result);
	}
	catch (WeatherDataEmptyListException e){
	    System.out.println(e.getMessage());
	}	
    }
}
