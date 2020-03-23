package Play_with_Data_Structures.Demo13Trie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 比较Trie 和 二分搜索树之间的性能差异
        compareBST();
    }

    private static void compareBST() {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }

            long endTime = System.nanoTime();

            // 纳秒向秒的转换
            double time = (endTime - startTime) / 1000000000.0; // 1*10的九次方

            System.out.println("Total diffrent words:" + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // -----

            System.out.println("Pride and Prejudice");

//            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

                startTime = System.nanoTime();

                Trie trie = new Trie();
                for (String word : words) {
                    trie.add(word);
                }
                for (String word : words) {
                    trie.contains(word);
                }

                endTime = System.nanoTime();

                // 纳秒向秒的转换
                time = (endTime - startTime) / 1000000000.0; // 1*10的九次方

                System.out.println("Total different words:" + trie.getSize());
                System.out.println("Trie: " + time + " s");

            }
        }
    }
}
