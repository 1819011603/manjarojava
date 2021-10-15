package com.company;

public class IsMatch {
    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
        //  f[i][j]  s[0:i-1]能否被p[j-1] 匹配
        boolean[][] f = new boolean[m + 1][n + 1];
        // ""  "" 长度为0肯定匹配
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                //  if p[j-1] == '*' 将*和前面的字符去掉  就有f[i][j] = f[i][j-2]  如果去掉p的两个字时fp[i][j-2] == true, 那现在ｆ[i][j]肯定为true
                //  如果去掉p的两个字时f[i][j-2] == false, 那现在ｆ[i][j]暂时为true
                //  if当前i的值不等于×前面的字符且  f[i][j-2] == false,那么ｆ[i][j] 肯定为false;
                // if当前i的值等于×前面的字符且f[i][j-2] == false,  if f[i-1][j] 是能匹配的　　再加一个字符f[0:i-1],ｐ[0:j-1]也能匹配
                if (p.charAt(j - 1) == '*') {
                    // 当　*和前面的字符不存在
                    f[i][j] = f[i][j - 2];
                    // if s[i-1] == *前面的字符　　ｆ[i][j]还有可能为true    *是0、多个匹配　　这里分为两种情况　0次和　ｔ个１次（t>=1）　
                    if (matches(s, p, i, j - 1)) {
                        // 　ｔ个１次（t>=1）　　baaaa  a*
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];

    }


    public boolean matches(String s, String p, int i, int j) {
        //  i == 0 没有字符　j>=1任何匹配都是false
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        // 相等返回ｔｒｕｅ
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch("aab","c*aa*b.*c*.*"));
    }
}
