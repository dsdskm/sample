package com.kkh.hackerrank.medium;

import java.math.BigInteger;

public class ExtraLongFactorials {
    public static void main(String args[]){
        extraLongFactorials(25);
    }

    static void extraLongFactorials(int n) {
        BigInteger ret = BigInteger.valueOf(1);
        for(int i=1;i<=n;i++){
            BigInteger bi = BigInteger.valueOf(i);
            ret = ret.multiply(bi);
        }
        System.out.println(ret);

    }
}
