public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        String s = "babad";
        System.out.println("Longest palindrome is: " + p.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        if(s.length() <= 1)
            return s;

        String pali = "";
        String temp = "";
        int n = s.length();
        char firstChar, secChar;
        for(int i = 0; i < n; i++){
            if(pali.length() >= s.substring(i, n- 1).length())
                break;
            firstChar = s.charAt(i);
            for (int j = s.length() - 1; j >= i; j--){
                secChar = s.charAt(j);
                if(firstChar == secChar){
                    if(isPalindrome(s.substring(i, j))){
                        temp = s.substring(i, j);
                        if(pali.length() < temp.length()){
                            pali = temp;
                        }
                        break;
                    }
                }
            }
        }

        if(pali == null)
            pali = s.valueOf(s.charAt(0));

        return pali;
    }

    private boolean isPalindrome(String s) {
        while(s.length() >= 1){
            if(s.charAt(0) != s.charAt(s.length() - 1))
                return false;
            else {
                if(s.length() <= 3)
                    return true;
                else
                    return isPalindrome(s.substring(1, s.length() - 2));
            }
        }

        return true;
    }
}
