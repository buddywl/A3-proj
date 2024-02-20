import org.w3c.dom.Node;

import java.util.*;

/**
 * Class to implement a singly linked list
 *
 * @author Buddy Luong
 * @version Spring 2024
 */

public class SLL<T> implements Phase1SLL<T>, Phase2SLL<T>, Phase4SLL<T>{
    public SLL(SLL<T> list) {
        if(!list.isEmpty()){
            NodeSL<T> current = new NodeSL<>(null, null);

            NodeSL<T> iterator = list.head;
            NodeSL<T> tempTail = new NodeSL<>(list.tail.getData());

            current.setData(iterator.getData());
            this.head = current;

            int index = 1;

            while(index < list.size()){
                NodeSL<T> next = new NodeSL<>(null, null);

                index++;
                next.setData(iterator.getNext().getData());

                iterator = iterator.getNext();

                current.setNext(next);
                current = next;
            }
            this.tail = current;
        } else {
            this.head = this.tail = null;
        }



//        NodeSL<T> previous = tempHead;
//        NodeSL<T> temp = null;
//        NodeSL<T> first = null;
//
//        while (previous != null) {
//            NodeSL<T> node = new NodeSL<T>(previous.getData());
//            if (first == null) {
//                first = node;
//                temp = first;
//            } else {
//                temp.setNext(node);
//                temp = temp.getNext();
//            }
//
//            previous = previous.getNext();
//        }
    }
    public SLL(){
    }


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

        if(isEmpty()){

        }else if (head == tail){
            string.append(head.getData().toString());
        }else{
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
            T value = head.getData();
            head = tail = null;
            return value;

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

        } else {
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
                NodeSL<T> next =  new NodeSL<>(null, null);

                index++;
                next.setData(here.getNext().getData());

                here = here.getNext();

                current.setNext(next);
                current = next;
            }
            nodes.tail = current;

            return nodes;
        }

    }

    public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere) {

        if(afterHere == list.getHead()){
            throw new SelfInsertException();
        } else {
            SLL<T> spliceCopy = new SLL<>(list);
            if(afterHere == null){
                spliceCopy.getTail().setNext(getHead());
                head = spliceCopy.getHead();
                tail = head;
                for(NodeSL<T> item = spliceCopy.head.getNext(); item != null; item = item.getNext()){
                    NodeSL<T> node = new NodeSL<>(item.getData());
                    tail.setNext(node);
                    tail = node;
                }
                list.tail.setNext(null);
            } else {
                SLL<T> spliced = new SLL<>();
                while (tail != afterHere){
                    T v = removeLast();
                    spliced.addFirst(v);
                }
                for (NodeSL<T> item = spliceCopy.getHead(); item != null; item = item.getNext()){
                    this.addLast(item.getData());
                }
                for (NodeSL<T> item = spliced.getHead(); item != null; item = item.getNext()){
                    this.addLast(item.getData());
                }
            }
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
        SLL<T> spliceNodes = new SLL<>(list);
        if(afterHere == spliceNodes.getHead()){
            throw new SelfInsertException();
        } else if (afterHere == null) {
            while(!list.isEmpty()){
                addFirst(list.removeLast());
            }
        } else {
            while(!list.isEmpty()){
                addAfter(afterHere, list.removeLast());
            }

        }
    }



}
