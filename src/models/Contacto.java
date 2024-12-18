package models;

public class Contacto <T, U> {
    private T name;
    private U phone;
       
    public Contacto(T name, U phone){
        this.name = name;
        this.phone = phone;
    }

    public T getName() {
        return name;
    }
    public void setName(T name) {
        this.name = name;
    }

    public U getPhone() {
        return phone;
    }
    public void setPhone(U phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contacto [name=" + name + ", phone=" + phone + "]";
    }

}
