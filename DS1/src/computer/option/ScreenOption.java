package computer.option;

import computer.ComputerConfiguration;

public class ScreenOption implements ConfigOption {

	private static final float SCREEN_PRICE = 150f; 
	
	@Override
	public ComputerConfiguration apply(ComputerConfiguration initialConfig) {		
		return initialConfig;
	}

	@Override
	public float additionalCost(ComputerConfiguration initialConfig) {
		return ScreenOption.SCREEN_PRICE;
	}

	@Override
	public String description() {
		return "add a Screen";
	}

	
}
