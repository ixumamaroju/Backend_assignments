import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
public class problem2 {
    public static void main(String[] args) {
        String[] employee={"Sai","Ravi","Sri","Sai","Ravi"};
        //converting array to arraylist
        ArrayList<String> list = new ArrayList<>(Arrays.asList(employee));
        System.out.println("Original ArrayList: " + list);

        //removing duplicates
        HashSet<String> set = new HashSet<>(list);
        for(String item : set){
            System.out.println(item);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(String item : list){
            if(map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        System.out.println("Frequency map: " + map);

        System.out.println("iterating using For-Loop");
        for( String word:list){
            System.out.println(word);
        }

        //using iterator
        System.out.println("iterating using Iterator");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
         

    }
}
