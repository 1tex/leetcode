import java.util.*;

public class huawei1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int S = scanner.nextInt();
        int Y = scanner.nextInt();
        scanner.nextLine();

        List<Work> works = new ArrayList<>();
        String[] scores = scanner.nextLine().split(" ");
        for (int i = 0; i < S; i++) {
            int score = Integer.parseInt(scores[i]);
            if (score > 20) {
                works.add(new Work(i + 1, score));
            }
        }

        works.sort((w1, w2) -> w2.score - w1.score);

        List<Work> winners = new ArrayList<>();
        int winningScore = works.get(Y - 1).score;
        for (Work work : works) {
            if (work.score == winningScore) {
                winners.add(work);
            }
        }

        winners.sort(Comparator.comparingInt(w -> w.id));

        System.out.print(winningScore);
        for (Work winner : winners) {
            System.out.print(" " + winner.id);
        }

    }

    public static class Work {
        int id;
        int score;

        public Work(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
