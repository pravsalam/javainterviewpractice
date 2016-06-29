/**
 * Created by praveenkumaralam on 12/28/15.
 */
public class TwoRectanglesIntersect {
    public static void main(String[] args){
        RectCords rect1 = new RectCords(2,4,0,2);
        RectCords rect2 = new RectCords(5,6,0,2);
        if( (rect2.lx <= rect1.lx && rect1.lx <= rect2.hx) ||
                (rect2.lx <= rect1.hx && rect1.hx <= rect2.hx)){
            if( (rect2.ly <= rect1.ly && rect1.lx <= rect2.hx) ||
                    (rect2.ly <= rect1.hy && rect1.hy <= rect2.hy))
                System.out.println(" rects intersect");
        }
    }
}
class RectCords{
    public int lx;
    public int hx;
    public int ly;
    public int hy;
    public RectCords(int a, int b, int c, int d){
        lx = a;
        hx = b;
        ly = c;
        hy = d;
    }
}
