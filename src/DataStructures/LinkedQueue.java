package DataStructures;

import Exceptions.*;
import ADTs.*;

public class LinkedQueue<T extends Comparable<T>> implements QueueADT<T> {

    SinglyLinkedNode<T> front;
    int size = 0;

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T element) {
        SinglyLinkedNode newNode = new SinglyLinkedNode<T>(element);
        if(isEmpty()){
            front = newNode;
        }
        else{
            SinglyLinkedNode<T> i = front;
            while(i.getNext() != null){
                i = i.getNext();
            }
            i.setNext(newNode);;
        }
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        T data;
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        data = front.getData();
        front = front.getNext();
        size--;

        return data;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        return front.getData();
    }

}