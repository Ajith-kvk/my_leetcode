class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> frequencyStringsMap = new HashMap<>();
        for(String str : strs) {
            String frequencyString = getFrequencyString(str);
            //if the frequency string is present, add the string to the list
            if(frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            }else {
                //else create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }
        return new ArrayList<>(frequencyStringsMap.values());
    }
    private String getFrequencyString(String str) {
        //Frequency buckets
        int[] freq = new int[26];
        //Iterate over each character
        for(char c : str.toCharArray()) {
            freq[c-'a']++;
        }
        //Start creating the frequency string
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for(int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
}