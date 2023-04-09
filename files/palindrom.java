public class Palindrom {

    public static boolean isPalindrome(String word) {
        char[] charset = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while(start < end) {
            if (charset[start] != charset[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String newWord = "abcbac";
        System.out.println(isPalindrome(newWord));
    }
}