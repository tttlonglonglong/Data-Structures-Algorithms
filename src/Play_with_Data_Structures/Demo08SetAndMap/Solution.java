package Play_with_Data_Structures.Demo08SetAndMap;
import java.util.TreeSet; // java底层的树结构，TreeSet是一个平衡二叉树，基于红黑树进行实现的

// 804. 唯一摩尔斯密码词
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word : words){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }

        return  set.size();
    }
}
