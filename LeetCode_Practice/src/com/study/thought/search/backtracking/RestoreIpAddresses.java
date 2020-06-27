package com.study.thought.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 还原IP地址
 * @Author Yin
 * @Date 2020/6/3 15:39
 * @Version 1.0
 **/
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0,sb,res,s);
        return res;
    }

    private void dfs(int depth, StringBuilder sb, List<String> res, String s) {
        // 深度为4或者长度用完就截止
        if(depth==4 || s.length()==0){
            // 刚好四段的情况下 加入结果集
            if (depth == 4 && s.length()==0){
                res.add(sb.toString());
            }
            return;
        }
        // 最多三位
        for (int i = 0; i < s.length() && i <= 2; i++) {
            // 0作为开头，只可能是只有一个0，其他情况排除
            if(i != 0 && s.charAt(0)=='0'){
                break;
            }
            // 截取
            String part = s.substring(0,i+1);
            // 值需要小于等于255
            if(Integer.parseInt(part) <= 255){
                // 除了开头情况都需要加  .
                if(sb.length()!=0){
                    part = "." + part;
                }
                sb.append(part);
                // 深度搜索
                dfs(depth+1,sb,res,s.substring(i+1));
                // 回溯
                sb.delete(sb.length() - part.length(),sb.length());
            }
        }
    }
}
