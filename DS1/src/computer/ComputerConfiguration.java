package computer;

public class ComputerConfiguration {

	private DriveConfiguration driveConfig;
	private int ram;
	private String cpu;
		
	public ComputerConfiguration(String cpu, int ram, DriveConfiguration driveConfig) {
		this.cpu = cpu;
		this.ram = ram;
		this.driveConfig = driveConfig;
	}

	public int getRam() {
		return this.ram;
	}

	public String getCPU() {
		return this.cpu;
	}
	
	public DriveConfiguration getDriveConfig() {
		return this.driveConfig;
	}

	public String toString() {
		return "computer config with cpu "+this.cpu+" and "+this.ram+" Go RAM and "+this.driveConfig;
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerConfiguration other = (ComputerConfiguration) obj;
		if (cpu == null) {
			if (other.cpu != null)
				return false;
		} else if (!cpu.equals(other.cpu))
			return false;
		if (driveConfig == null) {
			if (other.driveConfig != null)
				return false;
		} else if (!driveConfig.equals(other.driveConfig))
			return false;
		if (ram != other.ram)
			return false;
		return true;
	}

	
}
