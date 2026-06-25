class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch)) {
                sb.append(ch);
            }
        }
        String result = sb.toString();
        result = result.toLowerCase();
        if(checkPalindrome(result)) {
            return true;
        }
        return false;
    }
    private boolean checkPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}