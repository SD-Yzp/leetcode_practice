package com.study.thought.dynamic_programming.split_integer;

/**
 * @Description 解码方法
 * @Author Yin
 * @Date 2020/6/6 19:14
 * @Version 1.0
 **/
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("1201"));
    }

    public static int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int res = 1;
        // 记录前n-2、n-1结果
        int temp1 = 1;
        int temp2 = 1;
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        if((c1=='1' && c2!='0')||(c1=='2'&& (c2>='1' && c2<='6'))){
            res = 2;
            temp2 = res;
        }else if(c1!='1' && c1!='2' && c2=='0'){
            return 0;
        }
        for (int i = 2; i < s.length(); i++) {
            c1 = s.charAt(i - 1);
            c2 = s.charAt(i);
            if((c1=='1' && c2!='0')||(c1=='2'&& (c2>='1' && c2<='6'))){
                res = temp2 + temp1;
            }else if(c1!='1' && c1!='2' && c2=='0'){ // 出现无效条件
                  return 0;
            }else if((c1=='1' || c1=='2') && c2=='0'){
                res = temp1;
            }else{
                res = temp2;
            }
            temp1 = temp2;
            temp2 = res;
        }
        return res;
    }
}
