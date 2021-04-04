package com.kkh.codinginterview.ch09.sub01_array_string;

public class MyString {

    public MyString() {
        MyStringBuilder msb = new MyStringBuilder("ABC");
        msb.append("DEFGHI");
        msb.append("XYYYYY");
        System.out.println(msb.toString());
    }

    public static void main(String args[]) {
        new MyString();
    }

    public class MyStringBuilder {
        private int size = 10;
        private char[] chars = new char[size];
        private int index = 0;

        public MyStringBuilder(String s) {
            char tmp[] = s.toCharArray();
            System.out.println("tmp len : " + tmp.length);
            System.arraycopy(tmp, 0, chars, 0, tmp.length);
            index = tmp.length;
        }

        public void append(String value) {
            System.out.println("append value : " + value + " , index : " + index+" , chars : "+chars.length);
            if (chars.length <= index || chars.length <= (index + value.length())) {
                size = size+value.length()*2;
                char tmp[] = new char[size];
                System.arraycopy(chars, 0, tmp, 0, chars.length);
                chars = tmp;
            }
            int len = value.length();
            value.getChars(0, len, chars, index);
            index +=value.length();
        }

        public String toString(){
            return new String(chars, 0, chars.length);
        }
    }
}
