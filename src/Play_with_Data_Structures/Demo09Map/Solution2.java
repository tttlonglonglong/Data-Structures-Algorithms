package Play_with_Data_Structures.Demo09Map;
import java.util.ArrayList;
import java.util.TreeMap;
// 350. 两个数组的交集 II
// 给定两个数组，编写一个函数来计算它们的交集。
//        示例 1:
//        输入: nums1 = [1,2,2,1], nums2 = [2,2]
//        输出: [2,2]
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        // 出现的元素和频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer num : nums1) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num)-1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }
        int [] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
