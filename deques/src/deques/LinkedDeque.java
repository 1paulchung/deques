package deques;

public class LinkedDeque<T> extends AbstractDeque<T> {
    private int size;
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    Node<T> front;
    Node<T> back;
    // Feel free to add any additional fields you may need, though.

    public LinkedDeque() {
        size = 0;
        front = new Node(-1);
        back = new Node(-1, front, null);
        front.next = back;
    }

    public void addFirst(T item) {
        Node<T> temp = front.next;
        Node<T> newNode = new Node<>(item, front, temp);
        temp.prev = newNode;
        front.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node(item, back.prev, back);
        back.prev.next = newNode;
        back.prev = newNode;
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T val = front.next.value;
        front.next = front.next.next;
        front.next.prev = front;
        size -= 1;
        return val;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T val = back.prev.value;
        back.prev = back.prev.prev;
        back.prev.next = back;
        size -= 1;
        return val;
    }

    public T get(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        }
        Node<T> temp = front.next;
        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = back.prev;
            for (int i = 0; i < size - index - 1; i++) {
                temp = temp.prev;
            }
        }
        return temp.value;
    }

    public int size() {
        return size;
    }
}
