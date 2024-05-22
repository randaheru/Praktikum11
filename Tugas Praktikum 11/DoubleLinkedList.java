public class DoubleLinkedList {
    Node2 head, tail;
    int size;

    public DoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Film data) {
        Node2 newNode = new Node2(null, data, head);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Film data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node2 newNode = new Node2(tail, data, null);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(Film data, int index) throws Exception {
        if (isEmpty()) {
            addFirst(data);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == size) {
            addLast(data);
        } else {
            Node2 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            Node2 newNode = new Node2(current.prev, data, current);
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
            if (index == 0) {
                head = newNode;
            }
            size++;
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
            size--;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
            size--;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index < 0 || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node2 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void print() {
        if (!isEmpty()) {
            Node2 tmp = head;
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
            System.out.println("Sisa Antrian: " + size);
        } else {
            System.out.println("Daftar Film Kosong.");
        }
    }

    public int findById(int id) {
        Node2 current = head;
        int index = 0;
        while (current != null) {
            if (current.data.id == id) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void searchById(int id) {
        int index = findById(id);
        if (index != -1) {
            Node2 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data Id Film: " + id + " berada di node ke- " + (index + 1));
            System.out.println("IDENTITAS:\n" + current.data);
        } else {
            System.out.println("Film dengan ID " + id + " tidak ditemukan.");
        }
    }

    public void sortDescendingByRating() {
        if (size > 1) {
            boolean wasChanged;
            do {
                Node2 current = head;
                Node2 previous = null;
                Node2 next = head.next;
                wasChanged = false;
                while (next != null) {
                    if (current.data.rating < next.data.rating) {
                        wasChanged = true;
                        if (previous != null) {
                            Node2 sig = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node2 sig = next.next;
                            head = next;
                            next.next = current;
                            current.next = sig;
                        }
                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (wasChanged);
        }
    }
}
