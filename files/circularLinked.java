import java.util.NoSuchElementException;

public class circularLinked {

    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }
    
    public circularLinked() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = first;

        last = third;
    }

    public void display() {
        if(last == null) {
            return;
        }
        ListNode first = last.next;
        while(first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if(last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if(last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public ListNode removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Circular Single List is already empty");
        }

        ListNode temp = last.next;
        if(last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        circularLinked cll = new circularLinked();
        cll.createCircularLinkedList();
        cll.display();
    }
}