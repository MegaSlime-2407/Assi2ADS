public class MyQueue <T extends Comparable<T>> {
    private final MyLinkedList<T> list = new MyLinkedList<>();
    public void enqueue(T value) {
        list.addLast(value);
    }
    public T dequeue() {
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
    public T peek(){
        return list.getFirst();
    }
}
