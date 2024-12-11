package Materia.Stacks;
import java.util.EmptyStackException;

import Materia.Models.NodeGeneric;

public class StackGeneric <T> {
    private NodeGeneric<T> top;
    private int size;

    public StackGeneric() {
        this.top = null;
        this.size = 0;
    }

    // Metodo para agregar un elemento a la pila

    public void push(T data){
        NodeGeneric<T> newNode = new NodeGeneric<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void printStack(){
        NodeGeneric<T> current = top;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext(); 
        }
    }

    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public int getSize(){
        int cont = 0;
        NodeGeneric<T> current = top;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    public NodeGeneric<T> popNode(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        NodeGeneric<T> value = top;
        top = top.getNext();
        size--;
        return value;
    }
}
