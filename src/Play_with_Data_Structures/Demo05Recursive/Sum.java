package Play_with_Data_Structures.Demo05Recursive;

public class Sum {

    public static int Sum(int[] arr){
        return Sum(arr, 0);
    }

    // 计算arr[l...n]这个区间内所有数字的和
    private static int Sum(int[] arr, int l){
        if (l == arr.length)
            return 0;
        return arr[l] + Sum(arr, l+1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2,  3, 4, 5, 6,7,8};
        System.out.println(Sum(nums));
    }
}
