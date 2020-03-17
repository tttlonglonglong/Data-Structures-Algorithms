package Play_with_Data_Structures.Demo04LinkedList;

import java.util.Random;

public class Main {
    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");
        // 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作


//        LinkedListQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time3 = testStack(arrayQueue, opCount);
//        System.out.println("arrayQueue, time: " + time3 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");

    }

    public static void testLinkListed(){
        LinkedList<Object> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
    }
}
