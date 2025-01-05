package day18;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[100][100]; // 100x100 도화지
        int total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 색종이를 10x10 크기로 도화지에 표시
            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    if (!paper[row][col]) { // 아직 칠해지지 않은 부분만 체크
                        paper[row][col] = true;
                        total++;
                    }
                }
            }
        }

        System.out.println(total);
    }
}
