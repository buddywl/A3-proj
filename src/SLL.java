/**
 * Class to implement a singly linked list
 *
 * @author Buddy Luong
 * @version Spring 2024
 */

public class SLL<T> implements Phase1SLL<T>, Phase2SLL<T>, Phase4SLL<T>{

    public static void main(String[] args){

    }

//    public LinkedList<T> linkedList;
    private NodeSL<T> head;
    private NodeSL<T> tail;

    public NodeSL<T> getHead(){
        return this.head;
    }

    public NodeSL<T> getTail(){
        return this.tail;
    }

    public boolean isEmpty() {
        return getHead() == null;
    }

    public void addFirst(T v){
        NodeSL<T> node = new NodeSL<>(v);
        if(isEmpty()){
            head = node;
            tail = node;
        } else {
            NodeSL<T> temp = head;
            head = node;
            head.setNext(temp);
        }
    }

    public String toString(){
        StringBuilder string = new StringBuilder("[");
        if(!isEmpty()){
            string.append(head.getData().toString());
        }
        for (NodeSL<T> item = getHead(); item != getTail(); item = item.getNext()){
            string.append(", ");
            string.append(item.getNext().getData().toString());
        }
        string.append("]");
        return string.toString();
    }

    public void addLast(T v){
        NodeSL<T> node = new NodeSL<>(v, null);
        if(isEmpty()){
            head = node;
            tail = head;
        }

        NodeSL<T> temp = tail;
        tail = node;
        temp.setNext(tail);


    }

    public void addAfter(NodeSL<T> here, T v){
        NodeSL<T> node = new NodeSL<>(v);
        NodeSL<T> temp = here.getNext();
        if(isEmpty()){
            head = node;
            tail = head;
        }
        if(here == tail){
            addLast(v);
        } else{
            here.setNext(node);
            node.setNext(temp);
        }
    }

    public T removeFirst(){
        if(isEmpty()){
            throw new MissingElementException();
        } else{
            NodeSL<T> temp = head.getNext();
            T value = head.getData();

            head.setNext(null);
            head = temp;
            return value;
        }

    }

    public T removeLast() {
        if(isEmpty()){
            throw new MissingElementException();

        } else if (head == tail) {
            return removeFirst();

        } else{
            NodeSL<T> current = head;
            NodeSL<T> previous = current;
            T value = tail.getData();

            while(current != tail){
                previous = current;
                current = current.getNext();
            }
            previous.setNext(null);
            tail = previous;

            return value;
        }

    }

    public T removeAfter(NodeSL<T> here){
        if(isEmpty()){
            throw new MissingElementException();

        } else if (head == tail) {
            return removeFirst();

        } else {
            T value = here.getNext().getData();
            here.setNext(here.getNext().getNext());
            return value;
        }
    }

    public int size(){
        int count = 1;
        if(isEmpty()){
            return 0;
        } else {
            NodeSL<T> item = head;
            while(item != tail) {
                item = item.getNext();
                count++;
            }

            return count;
        }
    }

    public SLL<T> subseqByCopy(NodeSL<T> here, int n) {
        SLL<T> list = new SLL<T>();
        list.head = here;
        NodeSL<T> next = here.getNext();

        list.head.setNext(next);
        int index = 0;
        while(index!=n){
            index++;
            next = next.getNext();
        }

//        int index = 0;
//        NodeSL<T> current = here;
//        NodeSL<T> previous = current;
//        head = current;
//        while(index != n){
//            index++;
//            current = current.getNext();
//        }

        return null;
    }

    public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere) {

    }

    public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere) {
        return null;
    }


    public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere) {

    }
}
