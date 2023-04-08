public class linked {

    private ListNode head;

    private static class ListNode {
        private int data; // Generic type
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

            while (count < position - 1) { 
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
            while (count < position - 1) { 
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

        while(current != null ) { 
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
        ListNode slowPtr = head; 
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n) {
        if(head == null) {
            return null;                  
        } 
        if(n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }
         
        ListNode mainPtr = head;       // to understand
        ListNode refPtr = head;

        int count = 0;

        while(count < n) {
            if(refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

        if(head == null) {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;

        while(current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public void deleteNode(int key) {
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == key) {
            head = current.next;
            return;
        }

        if(current != null && current.data != key) {
            temp = current;
            current = current.next;
        }

        if(current == null ) {
            return;
        }

        temp.next = current.next;
    }

    public static void main(String[] args) {
        linked sll1 = new linked();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);

        linked sll2 = new linked();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(8);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);

        sll1.display();
        sll2.display();
    }
}