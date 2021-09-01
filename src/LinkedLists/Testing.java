package LinkedLists;

import DoublyLinkedList.DoublyLinkedList;

/* We’re going to model a (fictional) subway line that will travel from Central Park to the Brooklyn Bridge.
    In the .main() method create a new DoublyLinkedList instance named subway.
    The subway starts at Central Park and winds its way downtown. In the following order: add "Times Square", "Grand Cent
    Then print the list.
    The subway continues from Times Square down to the Brooklyn Bridge. In the following order: Add "Penn Station", "Wall Street", "Brooklyn Bridge" to the tail of the list
    Then print the list again.
    There’s construction happening on the subway line and the Central Park and Brooklyn Bridge stops will temporarily be closed. Note where these stops are in the list and remove them without iterating through the entire list.
    Then print the list again.
    It turns out that the Times Square station is under construction as well. Remove it from the list, and then print the list for the last time.
 */

public class Testing {
    public static void main(String[] args) {
        DoublyLinkedList subway = new DoublyLinkedList();
        subway.addToHead("Times Square");
        subway.addToHead("Grand Central");
        subway.addToHead("Central Park");
        subway.printList();
        subway.addToTail("Penn Station");
        subway.addToTail("Wall Street");
        subway.addToTail("Brooklyn Bridge");
        subway.printList();
        subway.removeHead();
        subway.removeTail();
        subway.printList();
        subway.removeByData("Times Square");
        subway.printList();
    }
}
