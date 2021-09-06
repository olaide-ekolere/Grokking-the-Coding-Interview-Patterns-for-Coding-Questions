import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int maxLength = 0, maxRepeat = 0, windowStart = 0;
        Map<Character, Integer> characters = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char current = str.charAt(windowEnd);
            characters.put(current, characters.getOrDefault(current, 0) + 1);
            maxRepeat = Math.max(maxRepeat, characters.get(current));
            if(windowEnd-windowStart-maxRepeat+1>k){
                char rem = str.charAt(windowStart++);
                characters.put(rem, characters.get(rem)-1);
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
