package dataStructure;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addFirst(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Queue Front[");
        for(int i = 0; i < getSize(); i++) {
            string.append(array.get(i));
            if(i != array.getSize() - 1) {
                string.append(',');
            }
        }
        string.append("] Tail");
        return string.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0; i < 20; i++) {
            queue.enqueue(i * 2);
        }
        System.out.println(queue);
    }
}
