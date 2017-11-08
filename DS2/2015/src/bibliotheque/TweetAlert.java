package bibliotheque;

/**  an alert system that sends message via twitter
 * @author JC
 *
 */
public class TweetAlert implements AlertSystem{

    private String twitterId;
	
    public TweetAlert(String twitterId){
	this.twitterId = twitterId;
    }

    @Override
    public void sendMessage(String msg){
	// send msg to this.twitterId
    }

    @Override
    public String getDescription(){
	return "tweet alert to "+this.twitterId;
    }
}
