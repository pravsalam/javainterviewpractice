import java.util.ArrayList;

class MedianFinder {
    ArrayList<Integer> arrlist = new ArrayList<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        insertNum(num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = arrlist.size();
        if(size%2 != 0) return arrlist.get(size/2+1);
        if(size%2 ==0 ) return (arrlist.get(size/2)+arrlist.get(size/2+1))/2;
        return 0;
    }
    private void insertNum(int num){
        int low = 0;
        int high = arrlist.size()-1;
        while(low<high){
            int mid = (low+high)/2;
            if(arrlist.get(mid) <= num && arrlist.get(mid+1) >= num){
                //we found the place to insert.
                arrlist.add(mid+1,num);
                return;
            }
            else if(arrlist.get(mid) > num){
                high = mid-1;
            }
            else if(arrlist.get(mid) < num){
                low = mid+1;
            }
        }
        arrlist.add(high, num);
    }
    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double median = obj.findMedian();
        System.out.println(median);
        obj.addNum(3);
        median = obj.findMedian();
        System.out.println(median);
        obj.addNum(4);
        median = obj.findMedian();
    }

};
