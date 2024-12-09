package Controller;

import Models.*;


public class ContactManager {
    private LinkedList<Contacto<?, ?>> contacts;

    public ContactManager(){
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contacto<?, ?>contact){
        contacts.appendToTail(contact);
    }

    @Override
    public String toString() {
        return "ContactManager [contacts=" + contacts + "]";
    }

}
