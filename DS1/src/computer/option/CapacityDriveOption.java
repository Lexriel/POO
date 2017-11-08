package computer.option;

import computer.ComputerConfiguration;
import computer.DriveConfiguration;

public class CapacityDriveOption implements ConfigOption {

	private static final float COEFF = 0.2f;
	
	private int newCapacity;
	
	public CapacityDriveOption(int newCapacity) {
		this.newCapacity = newCapacity;
	}

	@Override
	public ComputerConfiguration apply(ComputerConfiguration initialConfig) {
		DriveConfiguration newDrive = new DriveConfiguration(initialConfig.getDriveConfig().getHdType(),this.newCapacity);
		return new ComputerConfiguration(initialConfig.getCPU(),initialConfig.getRam(),newDrive);
	}

	@Override
	public float additionalCost(ComputerConfiguration initialConfig) {
		int initialCapacity = initialConfig.getDriveConfig().getHdCapacity();
		return (this.newCapacity-initialCapacity)*COEFF;
	}

	@Override
	public String description() {
		return "change drive capacity to "+this.newCapacity;
	}

}
