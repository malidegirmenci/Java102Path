import java.util.Arrays;

public class MyList <L>{
    private L[] elements;
    private int capacity= 10;
    private int size;
    public MyList(){
        this(10);
    }
    public MyList(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.elements = (L[]) new Object[capacity];
    }
    private void ensureCapacity(){
        int newCapacity = capacity * 2;
        L[] newElements = (L[]) new Object[newCapacity];
        System.arraycopy(elements,0,newElements, 0, elements.length);
        elements = newElements;
    }
    public int getCapacity(){
        return getCapacity();
    }

    public int getSize() {
        return size;
    }
    public void add(L element){
        if(this.size >= this.capacity){
            ensureCapacity();
        }else {
            elements[size++] = element;
        }
    }
    public L get(int index){
        if(index < 0 || index > size){
            return null;
        }
        return elements[index];
    }
    public void remove(int index){
        if(index < 0 || index > size){
            return;
        }
        elements[index] = null;
        System.arraycopy(elements,index+1,elements,index,elements.length-index);
    }
    public void set(int index, L element){
        if(index < 0 || index > size)
            return;
        elements[index] = element;
    }
    public int indexOf(L element){
        int currIndex = 0;
        while(currIndex < size){
            if(elements[currIndex] == element){
                return currIndex;
            }
            currIndex++;
        }
        return -1;
    }
    public int lastIndexOf(L element){
        int currIndex = size - 1;
        while(currIndex >= 0){
            if(elements[currIndex] == element)
                return currIndex;
            currIndex--;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public L[] toArray(){
        L[] returnElements = (L[]) new Object[size];
        for(int i = 0; i < size - 1; i++){
            returnElements[i] = elements[i];
        }
        return returnElements;
    }
    public void clear(){
        size = 0;
        elements = (L[]) new Object[capacity];
    }
    public MyList<L> subList(int start, int finish){
        if(start < 0 || start > size || finish < 0 || finish > size){
            return null;
        }
        MyList<L> returnedList = new MyList<>(finish - start);
        for (int i = start; i < finish; i++){
            returnedList.add(elements[i]);
        }
        return returnedList;
    }
    public boolean contains(L element){
        return indexOf(element) != -1;
    }
    @Override
    public String toString(){
        return Arrays.toString(elements);
    }
}
