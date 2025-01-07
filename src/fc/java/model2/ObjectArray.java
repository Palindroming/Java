package fc.java.model2;
import java.lang.Object;
import java.util.Arrays;


public class ObjectArray {

    private static final int DEFAULT_CAPACITY = 5;

     private Object[] elements; //다형성 배열

    private int size = 0;

    public ObjectArray(){
        this(5);
    } //생성자 안에서 다른 생성자를 호출할 때 사용
    public ObjectArray(int capacity){
        elements = new Object[capacity];

    }
    public int size(){
        return size;

    }
    public Object get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("범위 초과");
        }
        return elements[index];
    }

    public void add(Object element){
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
