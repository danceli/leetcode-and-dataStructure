package dataStructure;

public class LinkedListQueue<E> implements Queue<E> {

   public class Node {
       public E e;
       public Node next;

       public Node(E e, Node next) {
           this.e = e;
           this.next = next;
       }
       public Node(E e) {
           this(e, null);
       }
       public Node() {
           this(null, null);
       }
   }

   public Node head, tail;
   public int size;

   public LinkedListQueue() {
       head = null;
       tail = null;
       size = 0;
   }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null) {      //如果tail为空的时候，代表链表为空
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        size--;
        if(head == null) {
            tail = null;
        }
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Queue head[");
        Node cur = head;
        while(cur != null) {
            string.append(cur.e + "->");
            cur = cur.next;
        }
        string.append("null] tail");
        return string.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0; i < 8; i++) {
            queue.enqueue(i * 2);
        }
        System.out.println(queue);
        int ret = queue.dequeue();
        System.out.println(queue);

   }

}
