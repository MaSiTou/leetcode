package com.Test.test;

import java.util.*;

public class Main6 {
    static int[] dx = {0, 0, -1, 1}; // 左、右、上、下？不对，是上、下、左、右？
    static int[] dy = {-1, 1, 0, 0}; // 上、下、左、右

    static class Exit {
        int p, q; // 列，行

        public Exit(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    static class Eggy {
        int x, y, E_i, K_i, d; // x列，y行

        public Eggy(int x, int y, int E_i, int K_i) {
            this.x = x;
            this.y = y;
            this.E_i = E_i;
            this.K_i = K_i;
            this.d = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        while (P-- > 0) {
            int N = sc.nextInt(); // 行
            int M = sc.nextInt(); // 列
            int X = sc.nextInt(); // 蛋仔数
            int Y = sc.nextInt(); // 出口数
            int E = sc.nextInt(); // 初始能量

            List<Eggy> eggies = new ArrayList<>();
            for (int i = 0; i < X; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int E_i = sc.nextInt();
                int K_i = sc.nextInt();
                eggies.add(new Eggy(x, y, E_i, K_i));
            }

            List<Exit> exits = new ArrayList<>();
            for (int j = 0; j < Y; j++) {
                int p = sc.nextInt();
                int q = sc.nextInt();
                exits.add(new Exit(p, q));
            }

            char[][] maze = new char[N][];
            for (int i = 0; i < N; i++) {
                maze[i] = sc.next().toCharArray();
            }

            // 预处理每个出口的距离
            Map<Exit, int[][]> exitDist = new HashMap<>();
            for (Exit exit : exits) {
                int[][] dist = new int[N + 1][M + 1];
                boolean[][] visited = new boolean[N + 1][M + 1];
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{exit.p, exit.q, 0});
                visited[exit.q][exit.p] = true;
                dist[exit.q][exit.p] = 0;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];
                    int d = curr[2];
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 1 || nx > M || ny < 1 || ny > N) continue;
                        if (maze[ny - 1][nx - 1] == '#' || visited[ny][nx]) continue;
                        visited[ny][nx] = true;
                        dist[ny][nx] = d + 1;
                        queue.offer(new int[]{nx, ny, d + 1});
                    }
                }
                exitDist.put(exit, dist);
            }

            // 检查每个蛋仔的可行距离
            for (Eggy eggy : eggies) {
                for (Exit exit : exits) {
                    int[][] dist = exitDist.get(exit);
                    int d = dist[eggy.y][eggy.x];
                    if (d != 0 && d <= eggy.K_i) { // 0是出口本身，但题目说蛋仔初始不在出口
                        eggy.d = Math.min(eggy.d, d);
                    }
                }
                if (eggy.d == Integer.MAX_VALUE) {
                    System.out.println(-1);
                    P = -1; // 跳出所有循环
                    break;
                }
            }
            if (P == -1) continue;

            // 按d排序
            eggies.sort(Comparator.comparingInt(e -> e.d));

            long totalTime = 0;
            for (Eggy eggy : eggies) {
                int need = eggy.E_i - E;
                long wait = Math.max(0L, need);
                totalTime += (eggy.d + wait);
                E += (eggy.K_i - eggy.d);
            }

            System.out.println(totalTime);
        }
    }
}