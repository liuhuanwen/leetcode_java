package club.liuhw.simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {
        int temp = 0;
        while (x != 0) {
            int rev = x % 10;
            x = x / 10;
            if (temp > Integer.MAX_VALUE / 10 || temp == Integer.MAX_VALUE / 10 && rev > 7) return 0;
            if (temp < Integer.MIN_VALUE / 10 || temp == Integer.MIN_VALUE / 10 && rev < -8) return 0;
            temp = temp * 10 + rev;
        }
        return temp;
    }
}
