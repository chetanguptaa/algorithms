public class Linked {

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
         
        ListNode mainPtr = head;       
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

    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    public ListNode startNodeInLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while(temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
  
        while (fastPtr != null && fastPtr.next != null) {
           fastPtr = fastPtr.next.next;
           slowPtr = slowPtr.next;
  
           if (fastPtr == slowPtr) {
              removeLoop(slowPtr);
              return;
           }
        }
     }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while(temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail  = dummy;

        while(a != null && b != null) {
            if(a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if(a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Linked sll1 = new Linked();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);

        Linked sll2 = new Linked();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(8);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);

        sll1.display();
        sll2.display();

        Linked result = new Linked();
        result.head = merge(sll1.head, sll2.head);

        result.display();
    }
}