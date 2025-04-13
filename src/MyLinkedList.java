import java.util.Iterator;

public class MyLinkedList <T extends Comparable<T>> implements MyLIst<T> {
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyNode<T>{
    T data;
    MyNode<T> next,prev;
    public MyNode(T data) {
        this.data = data;
    }
}
private MyNode<T> head,tail;
private int size;
public MyLinkedList() {
    head = tail = null;
    size = 0;
}
@Override
public void add(T data) {
    addLast(data);
}

@Override
public void addLast(T data) {
    MyNode<T> newNode = new MyNode<>(data);
    if (head == null) {
        head = tail = newNode;
    }
    else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    size++;
}
@Override
public void addFirst(T data) {
    MyNode<T> newNode = new MyNode<>(data);
    if (head == null) {
        head = tail = newNode;
    }
    else {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    size++;
}
@Override
public void add(int index, T data) {
    checkIndex(index);
    if (index == 0) {
        addFirst(data);
    }
    else if (index == size) {
        addLast(data);
    }
    MyNode<T> current = head;
    for (int i = 0; i < index; i++) {
        current = current.next;
    }
    MyNode<T> newNode = new MyNode<>(data);
    newNode.prev = current.prev;
    newNode.next = current;
    current.prev.next = newNode;
    current.prev = newNode;
    size++;
}
@Override
public void set(int index, T data) {
    getNode(index).data = data;
}
@Override
public T get(int index) {
    return getNode(index).data;
}
@Override
public T getFirst() {
    if (head == null) {
        return null;
    }
    return head.data;
}
@Override
public T getLast() {
    if (tail == null) {
        return null;
    }
    return tail.data;
}
@Override
public void remove(int index) {
    MyNode<T> newNode = getNode(index);
    if(newNode.prev!=null) {
        newNode.prev.next = newNode.next;
    }
    else{
        head = newNode.next;
    }
    if(newNode.next!=null) {
        newNode.next.prev = newNode.prev;
    }
    else{
        tail = newNode.prev;
    }
    size--;
}
@Override
public void removeFirst() {
    remove(0);
}
@Override
public void removeLast() {
    remove(size - 1);
}

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(T item) {
        int index = 0;
        for(MyNode<T> n = head; n != null; n = n.next,index++) {
            if(n.data.equals(item)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        int index = 0;
        for(MyNode<T> n = tail; n != null; n = n.prev,index++) {
            if(n.data.equals(item)) {
                return index;
            }
        }
       return -1;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(MyNode<T> n = head; n != null; n = n.next,i++) {
            array[i] = n.data;
        }
        return array;
    }

    @Override
    public void clear() {
    head = tail = null;
    size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

}
