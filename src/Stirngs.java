public class Stirngs {
    /**
     * 最长回文子串，返回一个字符串中最大的回文子串
     * @param s 字符串
     * @return 字符串中最大的回文子串
     */
    //暴力法 列举所有的子串，判断是否为回文串，保存最长的回文串
    private static String longestPalindrome(String s) {
        int n = s.length();
        String ans = "" ;
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<=n;j++){
                String test =s.substring(i,j);
                if(isOalindromic(test)&&test.length()>max){
                    ans = s.substring(i,j);
                    max =Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    private static boolean isOalindromic(String s) {
        int len = s.length();
        for(int i = 0;i< len/2;i++){
            if(s.charAt(i)!=s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    //扩展中心:从一个字符开始扩展或者从两个字符之间开始扩展，

    /**
     * 共有2n+1个扩展点，分别对每个扩展点进行扩展 ，得到的最大回文子串保留下来
     * len1表示从一个元素扩展开
     * len2表示从两个元素中间扩展开
     * 获得的回文长度为len1和len2的较大者，对应到字符串的位置就是i的两侧
     *
     * @param s 字符串
     * @return 字符串的最大回文字符串
     */
    private static String longestPalindromes(String s) {
        if(s==null||s.length()<1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            //以i为中心对称的一个长度
            if(len > end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    //进行判断是否为回文字符串
    private static int expandAroundCenter(String s, int i, int j) {
        int L = i;
        int R = j;
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

    public static void main(String[] args) {
        String s= "asddsa";
        System.out.println(Stirngs.longestPalindrome(s));

        System.out.println(Stirngs.longestPalindromes(s));
    }
}
