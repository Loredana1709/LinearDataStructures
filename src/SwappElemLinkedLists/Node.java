package SwappElemLinkedLists;

public class Node {
    public int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }

    public Node getNextNode() {
        return this.next;
    }
}
