import javax.sound.midi.SysexMessage;
import java.util.Scanner;

/**
 * Created by praveenkumaralam on 12/28/15.
 */
public class LinkedList {
    ListNode head = null;
    public LinkedList(int[] a){
        if(a == null) return;
        int len = a.length;
        if(len ==0) return;
        ListNode prev = null;
        for(int i=0;i<len;i++){
            if(head == null){
                head = new ListNode(a[i]);
                head.next = null;
                prev = head;
                continue;
            }
            ListNode temp = new ListNode(a[i]);
            temp.next = null;
            prev.next = temp;
            prev = temp;
        }
        return;
    }
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        LinkedList list = new LinkedList(a);
        ListNode head = list.head;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println("You entered = "+input);
        }
//        ListNode reversehead = reverselist(head);
//        ListNode temp = reversehead;
//        while(temp !=null){
//            System.out.print(temp.data+" ");
//            temp = temp.next;
//        }
//        System.out.println();
        ListNode temp = reverseIngroups(head,3);
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    private static ListNode reverselist(ListNode head){
        ListNode p,q,r;
        if(head.next == null) return head;
        p = head;
        q = head.next;
        r = q.next;
        p.next = null;
        while( q != null) {
            q.next = p;
            p = q;
            q = r;
            if(r != null) r = r.next;
        }
        return p;
    }
    private static ListNode reverseIngroups(ListNode head, int k){
        ListNode p,q,r;
        if(head == null) return null;
        if(head.next == null) return head;
        p = head;
        q = head.next;
        r = q.next;
        int i=1;
        while(q!= null && i++<k){
            q.next = p;
            p  = q;
            q = r;
            if(r!= null ) r = r.next;
        }
        head.next = reverseIngroups(q, k);
        return p;
    }

}
class ListNode{
    public ListNode next;
    int data;
    public ListNode(int d){
        data = d;
    }
}