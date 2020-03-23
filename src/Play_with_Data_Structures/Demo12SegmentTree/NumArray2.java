package Play_with_Data_Structures.Demo12SegmentTree;

// 303. 区域和检索 - 数组不可变
// https://leetcode-cn.com/problems/range-sum-query-immutable/
// 因为是不可变数组，可以不使用线段树

// timeOut: 阶梯超时
public class NumArray2 {

    private int[] sum; // 预处理 sum[i]存储前i个元素和, sum[0] = 0
    private int[] data; // 复制一份nums

    // sum[i]存储nums[0....i-1]的和
    public NumArray2(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            data[i] = nums[i];

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i -1] + nums[i-1];

    }

    public void update(int index, int val){
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i -1] + data[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
