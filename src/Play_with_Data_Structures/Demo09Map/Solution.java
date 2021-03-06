package Play_with_Data_Structures.Demo09Map;
import java.util.ArrayList;
import java.util.TreeSet;


// leetcode:349. 两个数组的交集
//给定两个数组，编写一个函数来计算它们的交集。
//        示例 1:
//        输入: nums1 = [1,2,2,1], nums2 = [2,2]
//        输出: [2]
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1)
            set.add(num);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)){
                list.add(num);
                set.remove(num);// 防止 nums2 中有相同的元素
            }

        }
        int [] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
