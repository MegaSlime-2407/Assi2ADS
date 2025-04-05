public class MyArrayList {
    private int size;
    private Object[] elements;

    public MyArrayList(){
        this.elements =  new Object[10];
        this.size = 0;
    }

    public void addElement(Object element){
        if(size == elements.length){
            increaseBuffer();
        }
        elements[size++]=element;
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

    public void clear(){
        this.elements = new Object[10];
        this.size = 0;
    }

    public void remove(int index){
        checkIndex(index);
        for(int i = index + 1; i< size; i++){
            elements[i-1] = elements[i];
        }
    }

}