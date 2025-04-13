public class MyArrayList<T extends Comparable<T>> implements MyLIst<T> {
    private int size;
    private Object[] elements;

    public MyArrayList(){
        this.elements =  new Object[10];
        this.size = 0;
    }
@Override
    public void add(T item){
        if(size == elements.length){
            increaseBuffer();
        }
        elements[size++]=item;
    }

@Override
    public void add(int index, T item){
        checkIndex(index);
        if(size == elements.length){
            increaseBuffer();
        }
        for(int i=size; i>index; i--){
            elements[i]=elements[i-1];
            elements[index]=item;
            size++;
        }
    }
@Override
    public void set(int index, T item){
        checkIndex(index);
        elements[index]=item;
    }
@Override
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];
    }
    @Override
    public T getFirst(){
        return get(0);
    }
    @Override
    public T getLast(){
        return get(size - 1);
    }
@Override
    public void addFirst(T item){
        add(0,item);
    }
    @Override
    public void addLast(T item){
        add(item);
    }

    private void increaseBuffer() {
        Object[] temp = new Object[elements.length*2];
        for(int i=0;i<elements.length;i++){
            temp[i] = elements[i];
        }
        elements = temp;
    }

    public int getSize(){
        return size;
    }

    public int getLength() {
        return elements.length;
    }

    public Object getByIndex(int index) {
        checkIndex(index);
        return elements[index];
    }
    private void checkIndex(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }
@Override
    public void clear(){
        this.elements = new Object[10];
        this.size = 0;
    }
@Override
    public void remove(int index){
        checkIndex(index);
        for(int i = index + 1; i< size; i++){
            elements[i-1] = elements[i];
        }
    }
@Override
    public void removeFirst(){
        remove(0);
    }
    @Override
    public void removeLast(){
        remove(size - 1);
    }
@Override
    public int indexOf(T item){
        for(int i=0;i<size;i++){
            if(elements[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(T item){
        for(int i=size-1;i>=0;i--){
            if(elements[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean exists(T item){
        return indexOf(item)!=-1;
    }

    @Override
    public int size() {
        return size;
    }
@Override
    public void sort(){
        for(int i=1;i<size;i++){
            T key = (T) elements[i];
            int j=i-1;
            while(j>=0 && ((T) elements[j]).compareTo(key)>0){
                elements[j+1]=(T) elements[j];
                j--;
            }
            elements[j+1]=key;
        }
    }
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = elements[i];
        return result;
    }
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int index = 0;
            public boolean hasNext() {
                return index < size;
            }
            public T next() {
                return (T) elements[index++];
            }
        };
    }
}