import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호의 시작번호로 색인을 만들자.
        Map<String, List<String>> phones = new HashMap<>();
        
        for (String p : phone_book) {
            String firstNum = p.charAt(0) + "";
            List<String> numbers = phones.getOrDefault(firstNum, new ArrayList<>());
            numbers.add(p);
            phones.put(firstNum, numbers);
        }
        
        // 같은번호로 시작하는 것 끼리 탐색
        for (String key : phones.keySet()) {
            List<String> numbers = phones.get(key);
            Collections.sort(numbers);
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i).startsWith(numbers.get(i-1))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}