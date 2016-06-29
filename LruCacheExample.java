/**
 * Created by praveenkumaralam on 8/16/15.
 */
import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.collections.MapIterator;

import static java.lang.Thread.sleep;

public class LruCacheExample {
    private LRUMap lruMap;
    private int timeInterval;
    private int timeToLive;
    private class ObjectInMemory{
        private long timeCreated;
        private int value;
        public ObjectInMemory(int val){
            timeCreated = System.currentTimeMillis();
            value =val;
        }
    }
    public LruCacheExample(long ttl, int interval,int maxItems ){
        lruMap = new LRUMap(maxItems);
        timeInterval = interval;
        Runnable lruHandler = new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(timeInterval);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            //cleanup();
        };
    }
    public void put(int k, int value){
        lruMap.put(k, new ObjectInMemory(value));
    }
    public int get(int k){
        ObjectInMemory objInMemory = (ObjectInMemory)lruMap.get(k);
        objInMemory.timeCreated = System.currentTimeMillis();
        return objInMemory.value;
    }
    private void cleanup(){
        long currentTime = System.currentTimeMillis();
        MapIterator mapIter = lruMap.mapIterator();
        while(mapIter.hasNext()){
            
        }
    }

}
