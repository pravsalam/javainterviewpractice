package EventBus;

import java.util.ArrayList;

/**
 * Created by praveenkumaralam on 10/14/15.
 */
public class EventBus {
    ArrayList<Subscriber> subsList = new ArrayList<Subscriber>();
    public void register(Subscriber subscriber){
        subsList.add(subscriber);
    }

}

