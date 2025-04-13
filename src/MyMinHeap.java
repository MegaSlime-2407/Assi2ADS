public class MyMinHeap <T extends Comparable<T>> {
    private final MyArrayList<T> list = new MyArrayList<>();

    public void add(T element) {
        list.add(element);
        int i=list.size()-1;
        while(i>0){
            int j = (i-1)/2;
            if(list.get(j).compareTo(list.get(j))>0){
                break;
            }
            swap(i,j);
            i=j;
        }
    }
    public void swap(int i,int j){
        T temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    public T remove(){
        if(list.size()==0){
            return null;
        }
        T min=list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        heaping(0);
        return min;
    }
    private void heaping(int i){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<list.size() && list.get(left).compareTo(list.get(smallest))<0){
            smallest=left;
        }
        if(right<list.size() && list.get(right).compareTo(list.get(smallest))<0){
            smallest=right;
        }
        if(smallest!=i){
            swap(smallest,i);
            heaping(smallest);
        }
    }
    public T peek(){
        return list.get(0);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.size()==0;
    }
}
