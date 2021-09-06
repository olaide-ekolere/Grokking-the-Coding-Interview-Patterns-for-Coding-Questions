import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Set<Character> chars = new HashSet<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char c = str.charAt(windowEnd);
            if(chars.contains(c)){
                while(str.charAt(windowStart)!=c){
                    chars.remove(str.charAt(windowStart++));
                }
                chars.remove(str.charAt(windowStart++));
            }
            chars.add(c);
            maxLength = Math.max(maxLength, (windowEnd-windowStart)+1);
        }
        return maxLength;
    }
}
