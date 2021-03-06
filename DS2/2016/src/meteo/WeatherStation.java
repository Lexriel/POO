package meteo;

public class WeatherStation{

    private String id;
    private String name;
	
    public WeatherStation(String id, String name){
	this.id = id;
	this.name = name;
    }

    public String getId(){
	return this.id;
    }

    public String getName(){
	return this.name;
    }

    @Override
    public int hashCode(){
	int result = ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj){
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	WeatherStation other = (WeatherStation) obj;
	if (id == null){
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public String toString(){
	return "station "+this.name+" (id = "+this.id+")";
    }
}
