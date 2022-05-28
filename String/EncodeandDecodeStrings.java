public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            int size = str.length();
            sb.append(size);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index = 0;
        List<String> result = new ArrayList<>();
        while (index < s.length()) {
            StringBuilder wordBuilder = new StringBuilder();
            StringBuilder sizeBuilder = new StringBuilder();
            while (s.charAt(index) != '#') {
                sizeBuilder.append(s.charAt(index));
                index++;
            }
            int size = Integer.parseInt(sizeBuilder.toString());
            index++;
                
            while (size > 0) {
                wordBuilder.append(s.charAt(index));
                index++;
                size--;
            }
            result.add(wordBuilder.toString());
        } 
        return result; 
    }    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
