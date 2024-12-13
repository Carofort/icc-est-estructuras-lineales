import Controller.MenuController;
import Ejercicio_02_sorting.StackSorter;
import Ejercicio_01_sign.SignValidator;
import Materia.Queues.*;
import Materia.Stacks.*;
import models.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //runStack();
        //runStackGeneric();
        //runQueue();
        //runQueueGeneric();
        //MenuController menu = new MenuController();
        //menu.showMenu();
        int option;
        boolean exit = false;
        while(!exit){
            System.out.println("**MENU**");
            System.out.println("1. Sign Validator");
            System.out.println("2. Stack Sorter");
            System.out.println("3. Exit");
            System.out.println("Select one option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    firstExercise();
                case 2:
                    secondExercise();
                case 3:
                    exit = true;
                    System.out.println("Exiting.......");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } 
        
        scanner.close();
    }

    public static void firstExercise(){
        Scanner scanner1 = new Scanner(System.in);
        SignValidator validator = new SignValidator();

        System.out.println("Enter a String of Characters: ");
        String input = scanner1.nextLine();

        boolean result = validator.isValid(input);
        System.out.println("*Input: \"" + input + "\"");
        System.out.println("*Output: " + result);
        scanner1.close();
    } 

    public static void secondExercise(){
        Scanner scanner2 = new Scanner(System.in);
        StackGeneric<Integer> stack = new StackGeneric<>();

        System.out.println("Enter the numbers for the Stack (separated by spaces):");
        String inputStack = scanner2.nextLine();

        for (String num : inputStack.split(" ")) {
            try {
                stack.push(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                System.out.println("Only integers");
                scanner2.close();
                return;
            }
        }

        System.out.println("*Input: (tope) " + StackSorter.stackToString(stack));
        StackSorter.sortStack(stack);
        System.out.println("*Output: (tope) " + StackSorter.stackToString(stack));
        scanner2.close();

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
