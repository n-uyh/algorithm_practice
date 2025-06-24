import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> closet = new HashMap<>();
        // 옷장정리
        for (String[] c : clothes) {
            String type = c[1];
            List<String> list = closet.getOrDefault(type, new ArrayList<>());
            list.add(c[0]);
            closet.put(type, list);
        }
        
        // 한 종류의 의상 선택하는 경우의 수 : 안입는 경우 1 + (의상 개수 C(n,1) = n) => n + 1
        // 각 종류마다 동시 발생 : 곱하기
        // 전체 안입는 경우의 수 : 1 (마이너스 해줘야함)
        int answer = 1;
        for (String type : closet.keySet()) {
            answer *= (1 + closet.get(type).size());
        }
        return answer - 1;
    }
}