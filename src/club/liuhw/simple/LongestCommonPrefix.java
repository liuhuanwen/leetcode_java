package club.liuhw.simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] temp = new String[] {"abcdd", "abdcdd", "abcdcdd"};
        System.out.println(longestCommonPrefixBest(temp));
    }

    /**
     * 把字符串数组中第一个作为前缀子串，循环判断后面的元素是否以这个子串为前缀，
     * 只要某个元素不是，则缩短前缀子串重新遍历，直到子串长度为0，循环结束则前缀子串为最长的公共前缀
     * */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * 遍历第一个字符串的字符，只要数组中其他元素在同位置上的字符相同，继续遍历
     *
     * */
    private static String longestCommonPrefixBest(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
