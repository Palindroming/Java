package fc.java.model2;

import java.util.Arrays;


public class BookArray {

    private static final int DEFAULT_CAPACITY = 5;
    private BookDTO[] elements;
    private int size = 0;

    public BookArray(){
        elements = new BookDTO[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;

    }
    public BookDTO get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("범위 초과");
        }
        return elements[index];
    }

    public void add(BookDTO element){
        if(size==elements.length){
            ensureCapacity();
        }
        elements[size++] = element;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements,newCapacity);
    }
}
