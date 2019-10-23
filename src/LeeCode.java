import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class LeeCode {
    /**
     * 将数组中的0放置在数组的后面，非零的元素放在前面且位置不能改变
     * 将每个非零的元素覆盖前面为零的元素，最后将后面的元素置0
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
       for(int i = 0 ;i<nums.length;i++){
           if(nums[i]!=0){
               nums[index] = nums[i];
               index++;
           }
       }
       for(int i = index;i<nums.length;i++){
           nums[i] = 0;
       }
    }


    /**
     * 先找到数组中大于等于s的一个长度 然后动态的在接下来的元素中继续寻找
     * 寻找期间保持始终有一个长度大于等于s
     *
     * @param s 正整数
     * @param nums 数组
     * @return 数组中元素和大于等于s的最小长度
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum+=nums[i];
            while(sum>=s){
                ans = Math.min(ans,i+1-left);
                sum -= nums[left++];
            }
        }
        return (ans!=Integer.MAX_VALUE)?ans:0;
    }
    /**
     * 求数组中两个元素所在位置的值的和等于target的 两个位置，使用数组返回
     * @param numbers 目标数组
     * @param target 目标和
     * @return 数组（包含和等于target的下标）
     */
    private static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int n = numbers.length-1;
        while(i<n){
            if(numbers[i]+numbers[n]==target){
                return new int[]{i+1,n+1};
            }else if(numbers[i]+numbers[n]>target){
                n--;
            }else{
                i++;
            }
        }
        return null;
    }
    /**
     *将s转为小写，并将创建一个StringBuilder类型的字符串，若是数字或者小写字母添加到StringBuffer中
     * 判断StringBuffer类型的字符串是否等于他的逆序字符串
     * @param s 给定字符串
     * @return 是否给定字符串是一个回文字符串
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();

        StringBuilder str = new StringBuilder(1);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) str.append(c);
        }
            return str.toString().equals(str.reverse().toString());
        }

    /**
     * 给定两个有序的数组和每个数组中元素的个数，返回合并到nums1后的有序数组
     * 将nums2中的元素拷贝到num1中为0的地方，然后进行对num1的排序
     * @param nums1 数组1
     * @param m  数组1的非0元素个数
     * @param nums2 数组2
     * @param n 数组2的非0元素个数
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int aNums2 : nums2) {
            nums1[m++] = aNums2;
        }
            Arrays.sort(nums1);
    }



    /**
     * 原地删除数组中相同的元素，要求数组中最多有两个相同的元素
     * 遍历数组，当有两个连续的数字重复出现时候，先保存这个值，然后复制这两个重复的元素
     * 最后指针跳过相同的元素即可
     * 在做这道题的时候，一度数组越界，原来是我将 if(i<nums.length-1&&nums[i]==nums[i+1])写成了
     *  if(nums[i]==nums[i+1]&&i<nums.length-1)
     *  这让我又一次加深了对数组边界问题的理解，先判断界限再进行值的比较
     */
    private static int removeDuplicates(int[] nums) {
       int m = 0;
       for(int i = 0;i<nums.length;){
           if(i<nums.length-1&&nums[i]==nums[i+1] ){
               int val = nums[i];
               nums[m++]=nums[i++];
               nums[m++]=nums[i++];
               while(i<nums.length && nums[i]==val){
                   i++;
               }
           }else{
               nums[m++]=nums[i++];
           }
       }
       return m;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1,2,2,3,3,4,4,4};
        System.out.println(LeeCode.removeDuplicates(nums));
        int arr1[] = {1,2,3,0,0,0};
        int arr2[]={1,2,3};
        LeeCode.merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
        String s ="A man, a plan, a canal: Panama";
        System.out.println(LeeCode.isPalindrome(s));
        int []numbers ={2, 7, 11, 15};
        System.out.println(Arrays.toString(LeeCode.twoSum(numbers, 9)));
        int numsminlongArray[]={2,3,1,2,4,3};
        System.out.println(LeeCode.minSubArrayLen(7,numsminlongArray));

        int []moverzero = {1,0,2,2,3,0,0,};
        LeeCode.moveZeroes(moverzero);
        System.out.println(Arrays.toString(moverzero));
    }
}
