package computer;

public class DriveConfiguration {
	private HardDriveType hdType;
	private int hdCapacity;
	
	
	public HardDriveType getHdType() {
		return hdType;
	}

	public int getHdCapacity() {
		return hdCapacity;
	}

	public DriveConfiguration(HardDriveType hdType, int hdCapacity) {
		this.hdType = hdType;
		this.hdCapacity = hdCapacity;
	}

	public String toString() {
		return "drive "+this.hdType+" of "+this.hdCapacity+"Go";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriveConfiguration other = (DriveConfiguration) obj;
		if (hdCapacity != other.hdCapacity)
			return false;
		if (hdType != other.hdType)
			return false;
		return true;
	}
	
	
}
