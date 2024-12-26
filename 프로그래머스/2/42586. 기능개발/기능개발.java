import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        ArrayDeque<Integer> leftDays = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            leftDays.addLast((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while (!leftDays.isEmpty()) {
            int count = 1;
            int first = leftDays.pollFirst();
            while (!leftDays.isEmpty() && first >= leftDays.peekFirst()) {
                count++;
                leftDays.removeFirst();
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}