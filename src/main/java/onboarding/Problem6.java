package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    static List<List<String>> divTwoChar = new ArrayList<>();
    static HashMap<String, Integer> twoCharMap = new HashMap<>();
    static int numOfPeople = 0;

    public static void makeDivTwoCharList(List<String> names) {
        for(String name: names) {
            List<String> splitName = new ArrayList<>();
            for(int i=0; i<name.length()-1; i++) {
                splitName.add(name.substring(i, i+2));
            }
            divTwoChar.add(splitName);
        }
    }

    public static void makeTwoCharMap() {
        for(int i=0; i<numOfPeople; i++) {
            for(String twoChar: divTwoChar.get(i)) {
                if(twoCharMap.containsKey(twoChar)) {
                    int prevNum = twoCharMap.get(twoChar);
                    twoCharMap.put(twoChar, prevNum+i);
                } else {
                    twoCharMap.put(twoChar, i);
                }
            }
        }
    }

    public static List<String> getOverlapPersonEmail() {
        return new ArrayList<>();
    }

    public static List<String> solution(List<List<String>> forms) {
        numOfPeople = forms.size();
        makeDivTwoCharList(forms.stream()
                .map(form -> form.get(1))
                .collect(Collectors.toList()));
        makeTwoCharMap();
        return getOverlapPersonEmail();
    }
}
