package dataStructure;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack() {
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
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Stack [");
        for(int i = 0; i < getSize(); i++) {
            string.append(array.get(i));
            if(i != array.getSize() - 1) {
                string.append(',');
            }
        }
        string.append("]");
        return string.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0; i < 10; i++) {
            stack.push(i * 2);
        }

        System.out.println(stack);
    }
}
