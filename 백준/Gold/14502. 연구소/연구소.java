import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  
  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    };
  }

  static int N, M;
  static int[][] lab;
  static int safeZone = 0;
  static List<Point> infected;
  
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 연구소 세로 길이
    M = Integer.parseInt(st.nextToken()); // 연구소 가로 길이
    lab = new int[N][M];
    infected = new ArrayList<>(); // 바이러스 초기좌표

    // 0. 연구소 상태 파악
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < M; j++) {
        int value = Integer.parseInt(st.nextToken());
        lab[i][j] = value;
        if (value == 2) {
          infected.add(new Point(i, j));
        }
      }
    }

    buildWall(0);
    System.out.println(safeZone);
  }
  
  // 1.벽을 세우고
  static void buildWall(int num) {
    if (num == 3) {
      //벽 다세웠으니 바이러스 퍼뜨려
      infect();
     }
    else {
      for (int i = 0; i < lab.length; i++) {

        for (int j = 0; j < lab[0].length; j++) {
          if (lab[i][j] == 0) {
            lab[i][j] = 1;
            buildWall(num + 1);
            lab[i][j] = 0;
          }

        }
      }
      
    }
  }
  
  // 2. 바이러스 퍼뜨리고
  static void infect() {
    Queue<Point> queue = new LinkedList<>();
    // 초기바이러스 추가
    for (Point p : infected) {
      queue.offer(p);
    }

    int[][] tmpMap = new int[N][M]; // 연구소 카피 맵
    for (int i = 0; i < N; i++) {
      tmpMap[i] = lab[i].clone();
    }
    
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    // 퍼뜨리기
    while (!queue.isEmpty()) {
      Point from = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = from.x + dx[i];
        int ny = from.y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmpMap[nx][ny] == 0) {
          tmpMap[nx][ny] = 2;
          queue.offer(new Point(nx, ny));
        }
      }
    }

    CheckSafeZone(tmpMap);
  }
  // 3. 안전구역 카운트
  static void CheckSafeZone(int[][] map) {
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          cnt++;
        }
      }
    }

    safeZone = Math.max(cnt, safeZone);
  }
  
}

/*
0 : 빈칸 
1 : 벽 ( 새로 추가할 수 있는 벽은 3개)
2 : 바이러스

7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0  

27
*/