package EventBus;

/**
 * Created by praveenkumaralam on 10/14/15.
 */
public class Subscriber{
    int subscriberID;
    public Subscriber(int subID){
        subscriberID = subID;
    }
    public int getSubscriberID(){
        return subscriberID;
    }
}
