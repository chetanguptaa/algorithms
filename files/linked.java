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