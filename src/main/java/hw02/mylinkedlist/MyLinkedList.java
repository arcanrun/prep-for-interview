package hw02.mylinkedlist;

public class MyLinkedList<T> {
    private Node firstNode;
    private Node lastNode;
    private int size;

    private class Node {
        private T value;
        private Node next;
        private Node prev;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        Node(T value, Node prev) {
            this.value = value;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public MyLinkedList() {
    }

    public MyLinkedList(T... values) {
        Node prevNode = null;
        for (int i = 0; i < values.length; i++) {
            Node node = new Node(values[i]);
            if (i == 0) {
                firstNode = node;
                prevNode = firstNode;
                continue;
            }
            node.prev = prevNode;
            prevNode.next = node;
            prevNode = node;
        }
        size = values.length;
        lastNode = prevNode;

    }

    public boolean add(T value) {
        if (firstNode == null) {
            firstNode = new Node(value);
            lastNode = firstNode;
            size++;

            return true;

        }
        Node newNode = new Node(value, lastNode);
        lastNode.next = newNode;
        lastNode = newNode;
        size++;
        return true;
    }

    public T get(int index) {
        if (firstNode == null) {
            throw new RuntimeException("List is empty");
        }
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index = " + index + ", while size is " + size);
        }
        if (index == 0) {
            return firstNode.value;
        }
        if (index == size - 1) {
            return lastNode.value;
        }

        Node current = firstNode;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;

    }

    public boolean remvoe(T value) {
        if (firstNode == null) {
            return false;
        }
        Node current = firstNode;
        while (!current.value.equals(value)) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        if (firstNode == current) {
            if (firstNode.next == null) {
                firstNode = null;
                size--;
                return true;
            }
            firstNode = firstNode.next;
            firstNode.prev = null;
            size--;
            return true;
        }
        if (lastNode == current) {
            if (lastNode.prev == null) {
                lastNode = null;
                size--;
                return true;
            }
            lastNode = lastNode.prev;
            lastNode.next = null;
            size--;
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }

    public T getFirst() {
        if (firstNode == null) {
            throw new RuntimeException("List is empty");
        }
        return firstNode.value;
    }

    public T getLast() {
        if (firstNode == null) {
            throw new RuntimeException("List is empty");
        }
        return lastNode.value;
    }

    @Override
    public String toString() {
        StringBuilder render = new StringBuilder();
        Node current = firstNode;

        if (current != null && current.next == null) {
            render
                    .append(current)
                    .append(",");
        }

        if (current != null) {
            while (current != null) {
                render
                        .append(current)
                        .append(",");
                current = current.next;
            }
        }

        if (render.length() != 0) {
            render.deleteCharAt(render.length() - 1);
        }
        render.insert(0, "[");
        render.append("]");
        return render.toString();
    }
}
