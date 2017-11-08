package computer.option;

import computer.ComputerConfiguration;

/**
 * Defines option that apply to a computer configuration. Options are independent.
 * @see computer.ComputerConfiguration
 */
public interface ConfigOption {

	/** applies the effect of  this option to produce a new configuration from
	 * 	 the <code>initialConfig</code> configuration
	 * @param initialConfig the initial configuration to which this option applies 
	 * @return a new configuration obtained from the <code>initialConfig</code> configuration 
	 * 				after applying this option
	 */
	public ComputerConfiguration apply(ComputerConfiguration initialConfig);
	
	/** returns the additional cost due to this option when applied to 
	 *    the given initial configuration.
	 *    This additional cost can be negative if option decreases the price.<br/>
	 *    Price modifications due to options are independent: the price variation for a 
	 *    	configuration is always the same whatever other options are applied to 
	 *      this configuration.
	 * @param initialConfig the initial configuration to which this option is applied
	 * @return the additional cost due to this option
	 */
	public float additionalCost(ComputerConfiguration initialConfig);
	
	/** a description of this option
	 * @return a description of this option
	 */
	public String description();
}
