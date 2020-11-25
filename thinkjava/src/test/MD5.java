package test;

import cn.hutool.crypto.SecureUtil;

public class MD5 {
    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("123456"));
        System.out.println(SecureUtil.md5("13697425888"));
        System.out.println(SecureUtil.md5("13697425888wdj"));
        System.out.println(SecureUtil.md5("790794992"));
        System.out.println(SecureUtil.md5("790794992wdj"));
        System.out.println(SecureUtil.md5("admin"));
        System.out.println(SecureUtil.md5("111111"));
        System.out.println(SecureUtil.md5("djuw1999"));
        System.out.println(SecureUtil.md5("djwu"));
    }
}
