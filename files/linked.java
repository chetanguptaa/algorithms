import java.time.Period;

public class linked {

    private ListNode head;

    private static class ListNode {
        private int data; //Generic type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while(current != null) {
            System.out.println(current.data+ "-->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public int length() {
        if (head == null) {
            return 0;
        } 
        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
 
    public void insertFirst(int value) {
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    public void insert(int position, int value) {
        ListNode node = new ListNode(value);
        
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;

            while (count < position - 1) { // to understand
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public void insertLast(int value) {
        ListNode node = new ListNode(value);
        if(head == null) {
            head = node;
            return;
        }
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public void delete(int position) {
        if(position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) { // to understand
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public ListNode deleteLast() {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            ListNode temp = head;
            head = head.next;
            return temp;
        }
        ListNode current = head;
        ListNode  previous = null;
        while (current.next != null ) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public boolean find(int searchKey) {
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while(current.data == searchKey) {
            if(current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public ListNode reverse() {
        if(head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null ) { // to understand
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode getMiddleNode() {
        if(head == null) {
            return null;
        }
        ListNode slowPtr = head; // to understand
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        linked sll  = new linked();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // Now we will connect them together to form a chain

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        sll.display();
    }
}