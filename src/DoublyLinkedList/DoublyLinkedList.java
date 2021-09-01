package DoublyLinkedList;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void addToHead(String data){
        Node newHead = new Node(data); //Node that takes data as a parameter for its constructor
        Node currentHead = this.head; //Node that’s set to the list’s head

        if(currentHead != null){ //if there is a current head to the list:
            currentHead.setPreviousNode(newHead); //set currentHead‘s previous node to newHead
            newHead.setNextNode(currentHead); //set newHead‘s next node to currentHead
        }
        this.head = newHead; //set the list’s head to the new head

        if(this.tail == null){ //if the list doesn’t have a tail
            this.tail = newHead; //set the list’s tail to the new head
        }
    }

    public void addToTail (String data){
        Node newTail = new Node(data); //node that takes data as a parameter
        Node currentTail = this.tail; //node that’s set equal to the list’s tail

        if(currentTail != null){ //if there is a current tail to the list:
            currentTail.setNextNode(newTail); //set currentTail‘s next node to newTail
            newTail.setPreviousNode(currentTail); //set newTail‘s previous node to the current tail
        }
        this.tail = newTail; //set the list’s tail to the new tail

        if(this.head == null){ //if the list doesn’t have a head:
            this.head = newTail; //set the list’s head to the new tail
        }
    }

    public String removeHead(){
        Node removedHead = this.head; //node set equal to the list's head

        if (removedHead == null){ //check if removedHead has no value
            return null; //if so return null as there is nothing to remove
        }

        this.head = removedHead.getNextNode(); //set the list’s head to removedHead‘s next node
        if(this.head != null){ //If the updated head isn’t null (meaning that we hadn’t removed the only element in the list)
            this.head.setPreviousNode(null); //set the head’s previous node to null, since the head of the list shouldn’t have a previous node.
        }

        if(removedHead == this.tail){ //check if removedHead is equal to the list’s tail
            return this.removeTail();
        }
        return removedHead.data;
    }

    public String removeTail(){
        Node removedTail = this.tail; //create new node and set it equal to the list's tail

        if(removedTail == null){ //check if removedTail has no value:
            return null; //if so, means the list is empty and there's nothing to remove
        }
        this.tail = removedTail.getPreviousNode(); //set the list’s tail to removedTail‘s previous node

        if(this.tail != null){ //if the tail isn’t null (meaning that the list isn’t now empty)
            this.tail.setNextNode(null); //set the tail’s next node to null, since the tail of the list shouldn’t have a next node
        }

        if(removedTail == this.head){ //check if removedTail is equal to the list’s head
            return this.removeHead();
        }
        return removedTail.data;
    }

    public Node removeByData(String data){
        Node nodeToRemove = null;
        Node currentNode = this.head; //node set equal to the list's head
        while(currentNode != null){ //while loop that runs while currentNode isn’t null
            if(currentNode.data.equals(data)){ // checks if currentNode‘s data matches the passed in data
                nodeToRemove = currentNode;
                break; //leave the while loop, since we don’t need to keep looking through the list
            }
            currentNode = currentNode.getNextNode(); //update currentNode to be its next node
        }
        if(nodeToRemove == null){ //check if nodeToRemove has no value
            return null; //if so, that means there was no matching node in the list
        }
        if(nodeToRemove == this.head){ //check if nodeToRemove is the list’s head
            this.removeHead(); //call removeHead() method
        }
        else if(nodeToRemove == this.tail){ //check if nodeToRemove is the list’s tail
            this.removeTail(); ////call removeTail() method
        }
        else{ //now we know that the node is somewhere in the middle of the list
            //to remove it, we will need to reset the pointers for the nodes around it
            Node nextNode = nodeToRemove.getNextNode();
            Node previousNode = nodeToRemove.getPreviousNode();
            //remove the pointers to and from nodeToRemove and have nextNode and previousNode point to each other
            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        }
        return nodeToRemove;
    }

    public String printList() {
        Node currentNode = this.head;
        String output = "<head> ";
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }

}
