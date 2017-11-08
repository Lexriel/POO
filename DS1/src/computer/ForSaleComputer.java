package computer;

import computer.option.ConfigOption;

public class ForSaleComputer {

	public static final int NB_MAX_OPTIONS = 3;
	
	private ComputerConfiguration config;	
	private ConfigOption[] options;
	private float price;
	
	public ForSaleComputer(ComputerConfiguration initialConfig, float initialPrice) {
		this.config = initialConfig;
		this.price = initialPrice;
		this.options = new ConfigOption[ForSaleComputer.NB_MAX_OPTIONS];
	}
	
	public void setOption(ConfigOption option, int i) throws InvalidOptionException {
		if (i < 0 || i >= ForSaleComputer.NB_MAX_OPTIONS ) {
			throw new InvalidOptionException("option number not valid");
		}		
		this.options[i] = option;
	}
	
	public void removeOption(int i) throws InvalidOptionException {
		if (i < 0 || i >= ForSaleComputer.NB_MAX_OPTIONS ) {
			throw new InvalidOptionException("option number not valid");
		}		
		this.options[i] = null;
	}
	
	public ConfigOption getOption(int i)  throws InvalidOptionException {
		if (i < 0 || i >= ForSaleComputer.NB_MAX_OPTIONS ) {
			throw new InvalidOptionException("option number not valid");
		}		
		return this.options[i];
	}
	
	public ComputerConfiguration getFinalConfiguration() {
		ComputerConfiguration result = this.config;
		for(ConfigOption option : this.options) {
			if (option != null) {
				result = option.apply(result);
			}
		}
		return result;
	}
	
	public float getPrice() {
		float result = this.price;
		for(ConfigOption option : this.options) {
			if (option != null) {
				result = this.price + option.additionalCost(this.config);
			}
		}
		return result;
	}

	public String description() {
		String optionDesc = "";
		for(ConfigOption option : this.options) {
			if (option != null) {
				optionDesc = option.description();
			}
		}
		return this.config.toString()+optionDesc;
	}
	
}
