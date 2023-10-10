package queue;

import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;
    private static class ListNode {
        private final int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public Queue() {
        front = null;
        rear = null;
        length = 0;
    }
    public int length() {
        return length;
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if(isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }

        rear = temp;
        length++;
    }

    public void dequeue() {
        if(isEmpty()) throw new NoSuchElementException("queue.Queue is already empty");
        int result = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        length--;
    }

    public void print() {
        if(isEmpty()) return;
        ListNode current = front;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(7);
        queue.enqueue(21);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}