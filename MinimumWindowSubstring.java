import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        String minimum = "";
        int min = Integer.MAX_VALUE,  completed = 0, windowStart = 0;
        Map<Character, Integer> patternChars = new HashMap<>();
        for(char c : pattern.toCharArray()){
            patternChars.put(c, patternChars.getOrDefault(c, 0) + 1);
        }
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char current = str.charAt(windowEnd);
            if(patternChars.containsKey(current)){
                patternChars.put(current, patternChars.get(current) - 1);
                if(patternChars.get(current)==0){
                    completed++;
                }
                while(completed==pattern.length()){
                    if(windowEnd-windowStart+1<min){
                        min = windowEnd-windowStart+1;
                        minimum = str.substring(windowStart, windowEnd+1);
                    }
                    char rem = str.charAt(windowStart++);
                    if(patternChars.containsKey(rem)){
                        if(patternChars.get(rem)==0){
                            completed--;
                        }
                        patternChars.put(rem, patternChars.get(rem)+1);
                    }
                }
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
