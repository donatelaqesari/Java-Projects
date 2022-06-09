import java.util.HashMap;
import java.util.Set;

public class HashMapJava {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Ocean Drive", "We're riding down the boulevard...");
        trackList.put("Take Me To Infinity", "Don't you know you're taking me higher?...");
        trackList.put("Holdin On", "tell me where you're going...");
        trackList.put("Waves ", "My feet can't touch the ground...");

        String lyrics = trackList.get("We're riding down the boulevard...");
        //System.out.println(lyrics);
        for(String key : trackList.keySet()) {
            System.out.println(key);
            System.out.println(trackList.get(key));
        }
    }
}
