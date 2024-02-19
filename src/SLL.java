import org.w3c.dom.Node;

import java.util.*;

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
            for (NodeSL<T> item = getHead(); item != getTail(); item = item.getNext()){
                string.append(", ");
                string.append(item.getNext().getData().toString());
            }

        }
        string.append("]");
        return string.toString();
    }

    public void addLast(T v){
        NodeSL<T> node = new NodeSL<>(v, null);
        if(isEmpty()){
            head = node;
            tail = head;
        } else{
            NodeSL<T> temp = tail;
            tail = node;
            temp.setNext(tail);
        }


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
        } else if (head == tail) {
            head = tail = null;
            return head.getData();

        } else {
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

        } else if (here == null) {
            T value = head.getData();
            head = tail = null;
            return value;

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
        SLL<T> nodes = new SLL<T>();

        NodeSL<T> current = new NodeSL<>(null, null);
        NodeSL<T> next =  new NodeSL<>(null, null);

        if(isEmpty()){
            throw new MissingElementException();
        } else if (here == null || n == 0){
            return nodes;                                            //STILL NEED TO CODE THIS
        } else {

            current.setData(here.getData());
//            next.setData(here.getNext().getData());
            nodes.head = current;

            int index = 1;
            while (index < n){
                index++;
                next.setData(here.getNext().getData());
                current.setNext(next);
                current = next;
                System.out.println(index);

            }
            nodes.tail = current;

            return nodes;
        }

    }

    public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere) {
        NodeSL<T> toSplice = new NodeSL<>(null, null);
        NodeSL<T> current = new NodeSL<>(null, null);
        NodeSL<T> temp = list.head;

        toSplice.setData(list.head.getData());
        afterHere.setNext(toSplice);

        while(toSplice.getData() != temp.getData()){
            temp = temp.getNext();
            toSplice.setData(temp.getData());
        }



    }

    public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere) {
        SLL<T> nodes = new SLL<T>();

        if(isEmpty()){
            throw new MissingElementException();

        } else if (afterHere == null){
            NodeSL<T> start = head;
            NodeSL<T> end = toHere;
            nodes.head = start;
            nodes.tail = end;

            head = toHere.getNext();
            toHere.setNext(null);

            return nodes;
        } else if (toHere == null) {
            NodeSL<T> start = afterHere.getNext();
            NodeSL<T> end = tail;
            nodes.head = start;
            nodes.tail = end;

            tail = afterHere;
            afterHere.setNext(null);

            return nodes;
        } else {
            NodeSL<T> start = afterHere.getNext();
            NodeSL<T> end = toHere;
            nodes.head = start;
            nodes.tail = end;

            afterHere.setNext(toHere.getNext());
            toHere.setNext(null);

            return nodes;
        }
    }


    public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere) {

    }
}
