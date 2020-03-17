package Play_with_Data_Structures.Demo07BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public void testRemoveMax(){
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;

        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();

        while(!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");
    }

    public void testOrder(){
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
//        bst.preOrder();
//        System.out.println();
//        System.out.println(bst);

        bst.levelOrder();

//        bst.preOrderNR();
//        System.out.println();
//        System.out.println(bst);

//        bst.inOrder();
//        System.out.println();
////        System.out.println(bst);
//
//        bst.postOrder();
//        System.out.println();
////        System.out.println(bst);
    }
    public static void main(String[] args) {
        ( new Main()).testRemoveMax();
    }
}
