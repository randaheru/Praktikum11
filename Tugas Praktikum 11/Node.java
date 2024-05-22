public class Node {
    int nomorAntrian;
    String namaPenerima;
    Node prev, next;

    public Node(Node prev, int nomorAntrian, String namaPenerima, Node next) {
        this.prev = prev;
        this.nomorAntrian = nomorAntrian;
        this.namaPenerima = namaPenerima;
        this.next = next;
    }
}
