package hw02.mylinkedlist;

public class MyLinkedList<T> {
    private Node firstNode;
    private Node lastNode;

    private class Node {
        T value;
        Node next;
        Node prev;

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
            return value.toString() + "@" + hashCode();
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
        lastNode = prevNode;

    }

    public boolean add(T value) {
        if (firstNode == null) {
            firstNode = new Node(value);
            lastNode = firstNode;

            return true;

        }
        Node newNode = new Node(value, lastNode);
        lastNode.next = newNode;
        lastNode = newNode;
        return true;
    }

    public boolean remvoe(T value) {
        if (firstNode == null) {
            return false;
        }
        Node current = firstNode;
        while (!current.value.equals(value)) {
            current = current.next;
            if(current == null){
                return false;
            }
        }
        if (firstNode == current) {
            if (firstNode.next == null) {
                firstNode = null;
                return true;
            }
            firstNode = firstNode.next;
            firstNode.prev = null;
            return true;
        }
        if (lastNode == current) {
            if (lastNode.prev == null) {
                lastNode = null;
                return true;
            }
            lastNode = lastNode.prev;
            lastNode.next = null;
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
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
