public class Queue {
    Node head, tail;
    int size;

    public Queue() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int nomorAntrian, String namaPenerima) {
        Node newNode = new Node(tail, nomorAntrian, namaPenerima, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Data penerima vaksin berhasil ditambahkan.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada yang bisa dihapus.");
        } else {
            System.out.println("Data penerima vaksin dengan nomor antrian " + head.nomorAntrian + " dan nama " + head.namaPenerima + " telah divaksinasi.");
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Tidak ada pengantri vaksin.");
        } else {
            System.out.println("Daftar Pengantri Vaksin:");
            System.out.println("No.\tNama");
            Node current = head;
            while (current != null) {
                System.out.println(current.nomorAntrian + "\t" + current.namaPenerima);
                current = current.next;
            }
            System.out.println("Sisa Antrian: " + size);
        }
    }

    public int getSize() {
        return size;
    }
}
