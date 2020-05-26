package 算法;

public class 回文 {
    /**
     * 中心扩展法获取回文子串数量
     * @param s 目标字符串
     * @return 回文子串数量
     */
    public static int countSubStrings(String s){
        int n = s.length(), result = 0;
        /**
         * 对于给定的一个字符串如“abc”，回文子串中心可以是一个字符如a，也可以是两个字符中间，如a和b中间
         * 假设字符串长度为n，那么回文中心个数就是
         *  1      1
         *  2      3
         *  3      5
         *  n     2n-1
         */
        for(int center=0;center<2*n-1;center++){ //以每个回文中心向2侧扩展，直到不是回文子串
            /**
             * 假设字符串为ccccc，回文中心是第3个c，center为4，那么最小回文子串left为2，right为2
             * 如果回文中心是第3个c和第4个c中间，那么center为5，最小回文子串left为2，right为3
             * 回文中心是第4个c，那么center为6，最小回文子串left为3，right为3
             * 回文中心是第4个c和第5个c中间，那么center为7，最小回文子串left为3，right为4
             */
            int left=center/2; //左边界位置
            int right=left+left%2; //根据以上分析得出规律
            /**
             * 首先不能超出源字符串的边界，其次，由于我们按照回文中心往2边一个字符一个字符扩展，所以s.charAt(left)==s.charAt(right)就可以说明是回文子串
             */
            while(left>0 && right<n && s.charAt(left)==s.charAt(right)){ //满足回文子串的条件
                System.out.println(s.substring(left,right+1)); //输出结果
                left--;
                right++; //开始往2侧扩展
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubStrings("abbbc"));
    }
}
