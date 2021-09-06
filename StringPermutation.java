import java.util.HashMap;
import java.util.Map;


public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> patternChars = new HashMap<>();
        for(char c : pattern.toCharArray()){
            patternChars.put(c, patternChars.getOrDefault(c, 0)+1);
        }
        int completed = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char current = str.charAt(windowEnd);
            if(patternChars.containsKey(current)){
                patternChars.put(current, patternChars.get(current) - 1);
                if(patternChars.get(current)==0){
                    completed++;
                }
            }
            if(windowEnd-windowStart+1>pattern.length()){
                char rem = str.charAt(windowStart++);
                if(patternChars.containsKey(rem)){
                    if(patternChars.get(rem)==0){
                        completed--;
                    }
                    patternChars.put(rem, patternChars.get(rem)+1);
                }
            }
            if(completed==patternChars.size()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcaf", "abc"));
        System.out.println(findPermutation("odicf", "dc"));
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(findPermutation("aaccbb", "abc"));
    }
}
