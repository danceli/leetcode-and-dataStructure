package dataStructure;


public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;


    public LoopQueue(int capacpty) {
        data = (E[]) new Object[capacpty + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < data.length; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front) { //循环队列已满，扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }
    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("loopqueue is empty");
        }
        E ret = data[front];
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }
    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("LoopQueue front [");
        for(int i = front; i != tail; i = (i + 1) % data.length) {
            string.append(data[i]);
            if((i + 1) % data.length != tail) {
                string.append(",");
            }
        }
        string.append("]");
        return string.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i * 2);
        }
        System.out.println(queue);
        int ret = queue.dequeue();
        System.out.println(ret);
        System.out.println(queue);
    }
}
