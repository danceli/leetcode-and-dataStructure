package dataStructure;

public class Array<E> {
    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参的构造方法，默认数组的容量capacity为10
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }
    //数组的容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //向索引为index的数组中插入一个元素e
    public void add(E e, int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is validate");
        }
        if(size == data.length) {
            resize(data.length * 2);
        }
        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //像数组的最后一个元素添加元素
    public void addLast(E e) {
        add(e, size);
    }
    public void addFirst(E e) {
        add(e, 0);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for(int i = 0; i < size; i++) {
            string.append(data[i]);
            if(i != size - 1) {
                string.append(",");
            }
        }
        string.append("]");
        return string.toString();

    }
    //获取index索引位置的元素
    E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("get failed. index is illegal");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }
    public E getFirst() {
        return get(0);
    }

    //修改index索引位置的元素为e
    void set(int index , E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("set failed. index is illegal");
        }
        data[index] = e;
    }
    //查找数组中是否包含元素e
    public boolean contains(E e) {
        for(int i = 0; i < size; i++) {
            if(get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }
    //查找数组中元素e的索引所在，如果不存在元素e，则返回-1
    public int findIndex(E e) {
        for(int i = 0; i < size; i++) {
            if(get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove is failed index is illegal");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if(size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }
    //从数组中删除第一个元素，并返回删除的元素
    public E removeFirst() {
        return remove(0);
    }
    //从数组中删除最后一个元素，并返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }
    //从数组中删除元素e
    public void removeElement(E e) {
        int index = findIndex(e);
        if(index != -1) {
            remove(index);
        }
    }
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for(int i = 0; i < 10; i++) {
            array.addFirst(i + 1);
        }
        System.out.println(array);
        System.out.println(array.findIndex(8));
        array.removeFirst();
        System.out.println(array);
        for(int i = 0; i < 10; i++) {
            array.addLast(i * 2);
        }
        System.out.println(array);
    }
}
