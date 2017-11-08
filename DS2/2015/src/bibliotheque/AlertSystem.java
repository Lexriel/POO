package bibliotheque;

/** Represents an alert system who can send a message
 * @author JC
 *
 */
public interface AlertSystem{

    /** sends a message
     * @param msg the sent message
     */
    public void sendMessage(String msg);

    /** describes this alert system
     * @return a description of this alert system
     */
    public String getDescription();
}
