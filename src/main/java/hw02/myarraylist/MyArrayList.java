package hw02.myarraylist;

public class MyArrayList<T> {
    private T[] arr;
    private static final int INITIAL_CAPACITY = 10;
    private int currentCapacity;
    private double loadFactor = 0.75;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be higher then 0");
        }
        currentCapacity = initialCapacity;
        arr = (T[]) new Object[currentCapacity];
    }

    public MyArrayList() {
        currentCapacity = INITIAL_CAPACITY;
        arr = (T[]) new Object[currentCapacity];
    }

    private void calcCapacity() {
        if (size >= currentCapacity * loadFactor) {
            currentCapacity *= 2;
            T[] tempArr = (T[]) new Object[currentCapacity];
            if (size >= 0) System.arraycopy(arr, 0, tempArr, 0, size);
            arr = tempArr;
        }
    }

    public void add(T item) {
        calcCapacity();
        arr[size] = item;
        size++;
    }

    public void add(int index, T item) {
        checkIndex(index);
        calcCapacity();
        System.arraycopy(
                arr,
                index,
                arr,
                index + 1,
                size - index + 1
        );
        arr[index] = item;
        size++;
    }

    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public boolean remove(T item) {
        Integer index = null;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index != null) {
            for (int i = index; i <= size; i++) {
                arr[i] = arr[i + 1];
            }
            arr[size] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Wrong index=" + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder render = new StringBuilder();
        for (int i = 0; i < size; i++) {
            render.append(arr[i]).append(",");
        }
        if (render.length() > 0) {
            render.deleteCharAt(render.length() - 1);
        }
        render.insert(0, "[");
        render.append("]");

        return render.toString();
    }
}
