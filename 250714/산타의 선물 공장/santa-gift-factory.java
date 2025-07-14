// 순서대로, q개 명령
// 1. 공장설립
    // m개 벨트, n개 물건 -> 벨트당 n/m개 물건
    // 물건
        // id(고유번호), W(무게) - 무게 동일할 수 있음
// 2. 물건하차
    // 최대무게 w_max  1->m 벨트 순회, 맨앞 선물 확인
    // w_max 이하면 하차, 아니면 벨트 맨 뒤로
    // 하차 상자 무게 총합 출력
// 3. 물건 제거
    // 제거를 원하는 r_id 주어짐.
    // 제거후 r_id 출력, 없으면 -1 출력
// 4. 물건 확인
    // f_id, -> 찾으면 "벨트"번호 출력, 없으면 -1
    // 찾으면 해당상자부터 맨 뒤까지를 앞으로 이동(순서유지)
// 5. 벨트 고장
    // 고장난 벨트 번호 b_num
    // 벨트 오른쪽부터 순회하면서 상자 고장 안난 벨트 발견시 전체 옮김
    // 정상고장 처리시 bnum 출력, 이미 망가져있었다면 -1 출력
// 벨트 -> Queue, 벨트묶음 -> hashmap(key: 벨트번호)
import java.util.*;
import java.io.*;
public class Main {
    static class Box {
        int id;
        int w;
        public Box(int id) {
            this.id = id;
        }

        public void setW(int w) {
            this.w = w;
        }
    }

    static int n,m;
    static Map<Integer, Queue<Box>> belts = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "100":
                    establish(st);
                    break;
                case "200":
                    unloading(Integer.parseInt(st.nextToken()));
                    break;
                case "300":
                    remove(Integer.parseInt(st.nextToken()));
                    break;
                case "400":
                    check(Integer.parseInt(st.nextToken()));
                    break;
                case "500":
                    repair(Integer.parseInt(st.nextToken()));
                    break;
            }
        }
    }

    public static void establish(StringTokenizer st) {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= m; i++) {
            Queue<Box> boxes = new LinkedList<>();
            belts.put(i,boxes);
            for (int j = 0; j < n/m; j++) {
                boxes.add(new Box(Integer.parseInt(st.nextToken())));
            }
        }

        for (int i = 1; i <= m; i++) {
            Queue<Box> boxes = belts.get(i);
            for (int j = 0; j < n/m; j++) {
                Box b = boxes.poll();
                b.setW(Integer.parseInt(st.nextToken()));
                boxes.offer(b);
            }
        }
    }

    // 박스 하차
    public static void unloading(int w_max) {
        // 벨트 앞에서부터 순회
        int total_weight = 0;
        for (int i = 1; i <= m; i++) {
            Queue<Box> boxes = belts.get(i);
            if (boxes == null || boxes.isEmpty()) continue;
            Box b = boxes.poll();
            if (b.w <= w_max) {
                total_weight += b.w;
            } else {
                boxes.offer(b);
            }
        }
        System.out.println(total_weight);
    }

    // 박스 제거
    public static void remove(int r_id) {
        int result = -1;
        for (int i = 1; i <= m; i++) {
            Queue<Box> boxes = belts.get(i);
            if (boxes == null || boxes.isEmpty()) continue;
            int s = boxes.size();
            for (int j = 0; j < s; j++) {
                Box b = boxes.poll();
                if (b != null && b.id == r_id) {
                    result = r_id;
                } else {
                    boxes.offer(b);
                }
            }
            if (result != -1) {
                break;
            }
        }
        System.out.println(result);
    }

    // 물건 확인
    public static void check(int f_id) {
        int result = -1;
        A: for (int i = 1; i <= m; i++) {
            Queue<Box> boxes = belts.get(i);
            if (boxes == null || boxes.isEmpty()) continue;
            int s = boxes.size();
            for (int j = 0; j < s; j++) {
                Box b = boxes.peek();
                if (b != null) {
                    if (b.id == f_id) {
                        result = i;
                        break A;
                    } else {
                        boxes.offer(boxes.poll());
                    }
                }
            }
        }
        System.out.println(result);
    }

    // 벨트고장 -> 수리
    public static void repair(int b_num) {
        int result = -1;
        Queue<Box> move_boxes = belts.get(b_num);
        if (move_boxes != null) {
            belts.remove(b_num);
            
            for (int i = b_num; i < b_num + m; i++) {
                int move_num = (i % m) + 1;
                Queue<Box> target = belts.get(move_num);
                if (target != null) {
                    result = b_num;
                    while (move_boxes.size() > 0) {
                        target.offer(move_boxes.poll());
                    }
                    break;
                }
            }
        }
        System.out.println(result);
    }
}