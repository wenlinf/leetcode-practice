class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            for (char ch : word.toCharArray()) {
                sb.append(morse[ch - 'a']);
            }
            seen.add(sb.toString());
            sb.setLength(0);
        }
        return seen.size();
    }
}
