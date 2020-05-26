package 算法;

public class 回文 {
    /**
     * 中心扩展法获取回文子串数量
     * @param s 目标字符串
     * @return 回文子串数量
     */
    public static int countSubStrings(String s){
        int N = s.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubStrings("abc"));
    }
}
