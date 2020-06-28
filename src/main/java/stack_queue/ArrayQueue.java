package stack_queue;

public class ArrayQueue {
    private Integer first;
    private Integer last;
    private Integer[] arr;
    private Integer size;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        this.arr = new Integer[initSize];
        this.size = 0;
        this.first = 0;
        this.last = 0;
    }

    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        arr[last] = obj;
        size++;
        last = last == arr.length - 1 ? 0 : last++;
    }

    public Integer peek() {
        if (size == 0) {
            return 0;
        }
        return arr[first];
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = first;
        first = first == arr.length - 1 ? 0 : first + 1;
        return arr[tmp];
    }
}
