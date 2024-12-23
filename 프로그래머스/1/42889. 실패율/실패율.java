import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 실패율 = 분자(stages 값 카운트) / 분모 (팩토리얼)
        int[] now = new int[N+1]; // 현재 머물고 있는 stage count
        int[] passed = new int[N+1]; // 성공 count
        for (int i = 0; i < stages.length; i++) {
            int last = N;
            if (stages[i] != N+1) {
                last = stages[i];
                now[last]++;
            }
            for (int j = 1; j <= last; j++) {
                passed[j]++;
            }
        }
        Map<Integer, Double> failed_rates = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            if (now[i] == 0) {
                failed_rates.put(i, 0.0);
            } else {
                double r = (double) now[i] / passed[i];
                failed_rates.put(i, r);
            }
        }

        return failed_rates.keySet().stream().sorted(Comparator.comparing(failed_rates::get).reversed()).mapToInt(Integer::intValue).toArray();
    }
}