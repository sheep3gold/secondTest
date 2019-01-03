package com.itcast.first;

public class VariablePara {
    public static void main(String[] args) {
        int sum1 = getSum();
        int sum2 = getSum(1, 2);
        int sum3 = getSum(2, 3, 4, 5);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }
    public static int getSum(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
