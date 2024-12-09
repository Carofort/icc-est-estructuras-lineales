import Materia.Queues.Queue;
import Materia.Queues.QueueGeneric;
import Materia.Stacks.Stack;
import Materia.Stacks.StackGeneric;
import Models.Pantalla;

public class App {
    public static void main(String[] args) throws Exception {
        //runStack();
        //runStackGeneric();
        runQueue();
        //runQueueGeneric();
    }

    public static void runStack(){

        Stack stack = new Stack();

        stack.push(5);
        stack.push(7);
        stack.push(10);
        stack.push(20);

        stack.printStack();
        int cont = stack.getSize();
        System.out.println("Tamanio: " + cont);

        System.out.println(stack.getSize2());


        System.out.println("Cima    ->" + stack.peek());
        System.out.println("Retirar ->" + stack.pop());
        System.out.println("Cima    ->" + stack.peek());
        System.out.println("Retirar ->" + stack.pop());
        System.out.println("Cima    ->" + stack.peek());
    }

    public static void runStackGeneric(){
        StackGeneric<Pantalla> router = new StackGeneric<>();
        router.push(new Pantalla(1, "Home Page", "/home"));
        router.push(new Pantalla(1, "Menu Page", "/home/menu"));
        router.push(new Pantalla(1, "Users Page", "/home/menu/users"));

        System.out.println("Estoy en " + router.peek().getRuta());
        System.out.println("Regreso a " + router.popNode().getNext().getValue().getRuta());
        System.out.println("Estoy en " + router.peek().getRuta());

        router.push(new Pantalla(1, "Settings Page", "/home/menu/settings"));
        
        System.out.println("Pantallas = " + router.getSize());
        System.out.println("Estoy en " + router.peek().getRuta());
        router.printStack();
    }

    public static void runQueue(){
        Queue cola = new Queue();

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);

        System.out.println(cola.peek());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.peek());
    
    }

    public static void runQueueGeneric(){
        QueueGeneric<String> router = new QueueGeneric<>();
        router.push("Pablo");
        router.push("Pedro");
        router.push("Ana");

        System.out.println("Peek: " + router.peek());
        System.out.println("Next: " + router.popNode().getNext().getValue());
        System.out.println("Peek: " + router.peek());

        router.push("Maria");
        
        System.out.println("En la cola = " + router.getSize());
        System.out.println("Peek: " + router.peek());
        router.printQueue();
    }
}
