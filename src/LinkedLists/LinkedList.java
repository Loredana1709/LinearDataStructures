package LinkedLists;

public class LinkedList {
    public Node head;

    public LinkedList(){
        head = null;
    }

    public void addToHead(String data){
        Node newHead = new Node(data); //newHead takes data as an argument
        Node currentHead = head; //currentHead equal to the list's head
        head = newHead; // change the list head to the newHead

        //set new head’s next node to the past head, so that we can maintain the linked list
        if(currentHead != null){ //checks if there was a head to the list
            this.head.setNextNode(currentHead); //if there is, set the this.head's next node to currentHead
        }
    }

    public void addToTail(String data){
        Node tail = this.head; //set tail equal to the list's head

        if(tail == null){ //check if tail has no value
            this.head = new Node(data); //if so, set the list's head equal to a new Node that takes data as an argument
        }
        else{
            while(tail.getNextNode() != null){ //runs while tail has a next node
                tail = tail.getNextNode(); // set tai equal to its next Node
            }
            tail.setNextNode(new Node(data)); //set tail's next Node equal to a new Node that takes data as an argument
        }
    }

    public String removeHead(){
        Node removedHead = head; //setting equal to the list's head

        if(removedHead == null){ //if removedHead has no value
            return null; // the list has no head
        }
        this.head = removedHead.getNextNode(); //update the head of the list so that is no longer the removed head
        return removedHead.data; //data of the removed head
    }

    public String printList(){
        String output = "<head> ";
        Node currentNode = head;
        while(currentNode != null){
            output += currentNode.data + " ";
            currentNode.setNextNode(currentNode.getNextNode());
        }
        output += "<tail>";
        return output;
    }

    public static void main(String[] args) {
        LinkedList seasons = new LinkedList();
        seasons.printList();
        seasons.addToHead("summer");
        seasons.addToHead("spring");
        seasons.printList();
        seasons.addToTail("fall");
        seasons.addToTail("winter");
        seasons.printList();
        seasons.removeHead();
        seasons.printList();
    }

}
