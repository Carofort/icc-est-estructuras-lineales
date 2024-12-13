package Controller;

import Materia.Models.NodeGeneric;
import models.*;


public class ContactManager<T> {
    private LinkedList<Contacto<?, ?>> contacts;

    public ContactManager(){
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contacto<?, ?>contact){
        contacts.appendToTail(contact);
    }

    public void deleteContactByName(String name){
        NodeGeneric<Contacto<?,?>> current = contacts.getHead();

        if(current == null)
            return;

        //CASE 1: when contact is the HEAD
        if(((String)current.getValue().getName()).equalsIgnoreCase(name)){
            contacts.setHead(current.getNext());
            contacts.setSize(contacts.getSize() - 1);
            return;
        }
        //CASE 2 the rest
        while(current.getNext() != null){
            if (((String)current.getNext().getValue().getName()).equalsIgnoreCase(name)){
                current.setNext(current.getNext().getNext());
                contacts.setSize(contacts.getSize() - 1);
                return;
            }
            current = current.getNext();
        }
    }

    public void printList(){
        contacts.print();
    }

    public Contacto<?,?> findContactByName(String name){
        NodeGeneric<Contacto<?,?>> current = contacts.getHead();

        while(current != null){
            if(((String)current.getValue().getName()).equalsIgnoreCase(name)){
                return current.getValue();
            }
            current = current.getNext();
        }
        return null; 
    }
}
