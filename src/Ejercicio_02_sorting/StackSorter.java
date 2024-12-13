package Ejercicio_02_sorting;

import Materia.Stacks.StackGeneric;

public class StackSorter {

    public static void sortStack(StackGeneric<Integer> stack) {
        StackGeneric<Integer> auxStack = new StackGeneric<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!auxStack.isEmpty() && auxStack.peek() > temp) {
                stack.push(auxStack.pop());
            }
            auxStack.push(temp);
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }
    
    public static String stackToString(StackGeneric<Integer> stack) {
        StackGeneric<Integer> tempStack = new StackGeneric<>();
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            tempStack.push(value);
            sb.insert(0, "->" + value);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return sb.length() > 0 ? sb.substring(2) : ""; 
    }
}
