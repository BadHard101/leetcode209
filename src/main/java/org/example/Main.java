package org.example;

public class Main {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, min = Integer.MAX_VALUE, sum = nums[0];

        while (true) {
            while (sum < target) {
                right++;
                if (right == nums.length) {
                    if (min == Integer.MAX_VALUE) return 0;
                    else return min;
                }
                sum += nums[right];
            }
            min = Math.min(min, right-left+1);
            while (sum >= target) {
                sum -= nums[left];
                left++;
                if (sum >= target) min = Math.min(min, right-left+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}