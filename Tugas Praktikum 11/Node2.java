public class Node2 {
    Film data;
    Node2 prev, next;

    public Node2(Node2 prev, Film data, Node2 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
