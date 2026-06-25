class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> char_map = new HashMap<>();
        Map<String, Character> word_map = new HashMap<>();
        String words[] = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        for(int i=0; i<words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if(!char_map.containsKey(ch)) {
                if(word_map.containsKey(word)) {
                    return false;
                }else {
                    char_map.put(ch, word);
                    word_map.put(word, ch);
                }
            }else {
                String mappedWord = char_map.get(ch);
                if(!mappedWord.equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }
}