package ru.kpfu.itis.group11506.linkedStack;

public class Main {

    public static void main(String[] args) {
        String expression = "{34+[32_23]23 fdf}+ ()";
        char[] arr = expression.toCharArray();
        boolean isCorrect = false;
        Stack<Character> linkedStack = new LinkedStack<Character>();
        int index = 0;

        for (;arr.length > index; index++) {
            if (arr[index] == '[' | arr[index] == '{' | arr[index] == '(') {
                linkedStack.push(arr[index]);
            }
            if (arr[index] == ']' | arr[index] == '}' | arr[index] == ')') {
                if (linkedStack.peek() == null) {
                    isCorrect = false;
                    break;
                }
                if (linkedStack.peek() == (getAnotherBracket(arr[index]))) {
                    linkedStack.pop();
                    isCorrect = true;
                } else {
                    isCorrect = false;
                    break;
                }
            }
        }
        System.out.println("Expression " + expression + " is " + isCorrect);

        System.out.println("Start size - " + linkedStack.size());
        linkedStack.push('A');
        linkedStack.push('B');
        linkedStack.push('C');
        linkedStack.push('D');
        System.out.println("Size after pushed 4 nodes - " + linkedStack.size());
        System.out.println("Top element - " + linkedStack.peek());
        linkedStack.pop();
        linkedStack.pop();
        System.out.println("Size after delete 2 nodes - " + linkedStack.size());
        System.out.println("Top element - " + linkedStack.peek());
    }

    public static char getAnotherBracket(Character bracket) {
        if (bracket == ']') {
            bracket = '[';
        }
        if (bracket == '}') {
            bracket = '{';
        }
        if (bracket == ')') {
            bracket = '(';
        }
        return bracket;
    }
}