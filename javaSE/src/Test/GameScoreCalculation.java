package Test;

import java.util.Scanner;

public class GameScoreCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int score = calculateScore(input);
        System.out.println(score);
        scanner.close();
    }

    public static int calculateScore(String input) {
        int score = 0;
        int comboCount = 0;
        int missCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == 'M') {
                missCount++;
                comboCount = 0;
                if (missCount == 3) {
                    System.out.println("你已经输掉了游戏！");
                    return score;
                }
            } else if (current == 'G') {
                score += 5;
                comboCount = 0;
            } else if (current == 'P') {
                if (comboCount >= 3) {
                    score += 15;
                } else {
                    score += 10;
                }
                comboCount++;
            }
        }
        return score;
    }
}    