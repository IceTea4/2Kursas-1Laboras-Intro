package utils;

import java.lang.reflect.GenericDeclaration;
import java.util.Iterator;

/*
Realizuokite visus interfeiso metodus susietojo sarašo pagrindu.
Nesinaudokite java klase LinkedList<E>, visa logika meginkite parasyti patys.
Jeigu reikia, galima kurti papildomus metodus ir kintamuosius.
*/
public class LinkedList<T> implements List<T> {
    
    private class Node{
        private T item;
        private Node next;

        Node (T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Node head;
    public Node current;
    public Node tail;

    public LinkedList(){
        head = null;
        current = null;
        tail = null;
    }

    @Override
    public void add(T item) {
        Node node = new Node(item, null);

        if (head != null){
            tail.next = node;
            tail = node;
        }
        else {
            head = node;
            tail = node;
        }
    }

    @Override
    public T get(int index) {
        current = head;
        for (int i = 0; current != null; i++){
            if (index == i){
                return current.item;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public boolean remove(T item) {
        Node before = head;

        if (item.equals(head.item)){
            if (head.next == null){
                head = null;
            }
            else {
                head = head.next;
            }
            return true;
        }
        else if (!item.equals(tail.item)){
            for (current = head.next; current.next != null; current = current.next){
                if (current.item == item){
                    current = before;
                    current.next = before.next.next;
                    return true;
                }
                before = before.next;
            }
        }
        else {
            tail = before;
            return true;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;
            @Override
            public boolean hasNext() {
                return get(idx) != null;
            }

            @Override
            public T next() {
                return get(idx++);
            }
        };
    }
}
