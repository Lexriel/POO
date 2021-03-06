package meteo;

import java.util.List;

/**
 * aggregates weather data from a list to produce a global value 
 */
public interface Operation{

    /** process data in dataList to produce a global value
     * @param dataList the weather data list, it is assumed to be not empty
     * @return the computed value
     */
    public double process(List<WeatherData> dataList);

    /** returns a description of this operation 
     * @return a description of this operation
     */
    public String getDescription();
}
