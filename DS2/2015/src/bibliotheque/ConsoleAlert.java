//Q 9
package bibliotheque;

/**  an alert system that prints message to console to send it
 * @author JC
 *
 */
public class ConsoleAlert implements AlertSystem{

    public ConsoleAlert(){
    }

    @Override
    public void sendMessage(String msg){
	System.out.println(msg);
    }

    @Override
    public String getDescription(){
	return "console (stdout) alert system ";
    }
}
