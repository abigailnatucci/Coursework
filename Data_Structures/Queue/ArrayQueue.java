import java.util.NoSuchElementException;

public class ArrayQueue<E> implements PureQueue<E> {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] theData;

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCap){
        capacity = initialCap;
        theData = (E[]) (new Object[capacity]);
        front = 0;
        size = 0;
        rear = capacity -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean offer(E o) {
        if(size == capacity) {
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        theData[rear] = o;
        return true;
    }

    private void reallocate() {
        int newCap = 2 * capacity;
        E[] newData = (E[]) (new Object[newCap]);
        int f = front;
        for(int i = 0; i<size; i++){
            newData[i] = theData[i];
            f = (f + 1) % capacity;
        }
        front = 0;
        rear = size -1;
        capacity = newCap;
        theData = newData;
    }

    @Override
    public E poll() {
        if(size == 0)
            return null;
        E result = theData[front];
        front = (front + 1) % capacity;
        size --;
        return result;
    }

    @Override
    public E remove() {
        if(size == 0)
            throw new NoSuchElementException();
        E result = theData[front];
        front = (front + 1) % capacity;
        size --;
        return result;
    }

    @Override
    public E peek() {
        if(size == 0)
            return null;
        else{
            return theData[front];
        }
    }

    @Override
    public E element() {
        if(size == 0)
            throw new NoSuchElementException();
        else{
            return theData[front];
        }
    }

    public void clear(){
        this.size = 0;
    }

    public String toString(){
        if(isEmpty())
            return "[]";
        String result = "[";
        result += theData[front];
        for(int i = 1; i<size; i++){
                result += ", " + theData[(i+front)%capacity];
        }
        result += "]";
        return result;
    }
}
