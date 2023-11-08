package backtracking;

import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses {
    private static int l;
    private static List<String> list;
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
    public static List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        l = s.length();
        backtrack(s, 0, "", 0);
        return list;
    }
    private static void backtrack(String s, int index, String ip, int dot) {
        if(dot == 3) {
            if(isValidIP(s.substring(index))) {
                ip += s.substring(index);
                list.add(ip);
            }
            return;
        }
        for(int i = index; i < l; i++){
            if(isValidIP(s.substring(index, i + 1))){
                int k = s.substring(index, i + 1).length();
                ip += s.substring(index, i + 1) + ".";
                backtrack(s, i + 1, ip, dot + 1);
                ip = ip.substring(0, ip.length() - k - 1);
            }
        }
    }
    private static boolean isValidIP(String ip){
        if(ip.length() > 3 || ip.length() == 0) return false;
        if(ip.length() > 1 && ip.charAt(0) == '0') return false;
        if(ip.length() > 0 && Integer.parseInt(ip) > 255) return false;
        return true;
    }
}
