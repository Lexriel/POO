package meteo;

import java.util.*;

public class WeatherAnalysis{

    /**
     * the data managed by this object : associates a station with the list of
     * weather data known for this station
     */
    private Map<WeatherStation, List<WeatherData>> allData;

    /** builds a WeatherAnalysis object with an initial empty allData map */
    public WeatherAnalysis(){
	this.allData = new HashMap<WeatherStation, List<WeatherData>>();
    }

    /**
     * Adds a list of new weather data to the given station. If station is not
     * yet known, it is added, else data in the list are added to already
     * existing data.
     * 
     * @param station
     *            the station for which data are given
     * @param dataList
     *            the list of weather data added for given station
     */
    protected void addDailyDataForStation(WeatherStation station, List<WeatherData> dataList){
	if (this.allData.containsKey(station)){
	    this.allData.get(station).addAll(dataList);
	} else{
	    this.allData.put(station, dataList);
	}
    }

    /**
     * registers received weather data into allData
     * 
     * @param dailyData
     *            the received data : a map that associated station to the list
     *            of data that must be added to each station in allData
     * @see WeatherAnalysis#addDailyDataForStation(WeatherStation, List)
     */
    public void receiveDailyData(Map<WeatherStation, List<WeatherData>> dailyData){
	for (WeatherStation station : dailyData.keySet()){
	    this.addDailyDataForStation(station, dailyData.get(station));
	}
    }

    /**
     * Performs some operation on the list of data known for given station. The
     * result of the operation is returned.
     * 
     * @param station
     *            the station
     * @param operation
     *            the operation to be executed on the data list
     * @return the result of operation processing on the list of data for the
     *         given station
     * @throws WeatherDataEmptyListException
     *             if there exists no data for the given station
     */
    public double processData(WeatherStation station, Operation operation) throws WeatherDataEmptyListException{
	List<WeatherData> dataList = this.allData.get(station);
	if (dataList == null || dataList.isEmpty()){
	    throw new WeatherDataEmptyListException("no data for station " + station);
	}
	double result = operation.process(dataList);
	return result;
    }
}
