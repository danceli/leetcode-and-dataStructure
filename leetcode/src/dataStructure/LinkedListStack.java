package dataStructure;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public E peek() {
        return (E) list.getFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return (E) list.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Stack [");
        for(int i = 0; i < list.getSize(); i++) {
            string.append(list.get(i));
            if(i != list.getSize() - 1) {
                string.append(",");
            }
        }
        string.append("]");
        return string.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(6);
        System.out.println(stack);
    }
}
