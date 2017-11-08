package bibliotheque;

/** an alert system that sends message using sms
 * @author JC
 *
 */
public class SMSAlert implements AlertSystem{

    private String phoneNumber;
	
    public SMSAlert(String phoneNumber){
	this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendMessage(String msg){
	// send msg to this.phoneNumber
    }

    @Override
    public String getDescription(){
	return "sms alert to "+this.phoneNumber;
    }
}
