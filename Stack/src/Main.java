import javax.xml.bind.Element;
import java.util.Random;

public class Main {

    public static double performanceTest(Stack stack, int operationCount){
        long nowTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operationCount; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < operationCount; i ++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - nowTime) / 100000000.0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i ++) {
            stack.push(i);
        }
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());

        Solution solution = new Solution();
        System.out.println(solution.isValid("[]"));


        LinkedListStack<Integer> llStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i ++) {
            llStack.push(i);
        }
        System.out.println(llStack);

        llStack.pop();
        System.out.println(llStack);

        System.out.println(llStack.peek());

        int operationCount = 100000;
        ArrayStack<InternalError> arrayStack = new ArrayStack<>();
        double arrayStackTime = performanceTest(arrayStack, operationCount);
        System.out.println("Array Stack time is " + arrayStackTime);

        LinkedListStack<InternalError> linkedListStack = new LinkedListStack<>();
        double linkedListStackTime = performanceTest(linkedListStack, operationCount);
        System.out.println("LinkedList Stack time is " + linkedListStackTime);

    }
}
