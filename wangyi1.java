//现在需要你实现一个比赛分数的统计程序，判断出胜利属于哪一支队伍，以及该场比赛的MVP是哪位球员。
//        MVP是指在本场比赛中得分最高的球员，如果有多位球员得分相同的话，最先达到最高得分的球员为MVP。
//        输入描述
//        输入一个整数n(1<=n<=500)，表示该场比赛有n次得分情况。
//        接着一行是两个字符串，表示两个队伍的名称。
//        接着是n行，每行开始是两个字符串，表示球员名字和所在队伍，球员名字和队伍名称不会出现空格，并且长度小于50个字符。然后是一个整数k，(1<=k<=3)，表示该球员本次的得分。
//        n行得分数据按照时间先后顺序给出。
//        输出描述
//        输出两行，第一行是获胜队伍的名称，如果平局的话，请输出"ended in a draw"，第二行是该场MVP的名字。
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        10
//        TeamA TeamB
//        Durant TeamA 3
//        Thompson TeamA 2
//        Curry TeamA 2
//        Jokic TeamB 3
//        James TeamB 3
//        Thompson TeamA 1
//        James TeamB 3
//        James TeamB 3
//        Curry TeamA 3
//        Durant TeamA 2
//        输出
//        复制
//        TeamA
//        James
//        示例2
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        2
//        A B
//        1 A 2
//        2 B 2
//        输出
//        复制
//        ended in a draw
//        1


import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class wangyi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String teamA = in.next();
        String teamB = in.next();
        in.nextLine();

        HashMap<String, Integer> playerScore = new HashMap<>();
        HashMap<String, Integer> teamScore = new HashMap<>();
        teamScore.put(teamA, 0);
        teamScore.put(teamB, 0);

        String mvp = "";
        int mvpScore = 0;

        for (int i = 0; i < n; i++) {
            String playerName = in.next();
            String teamName = in.next();
            int score = in.nextInt();
            in.nextLine();

            playerScore.put(playerName, playerScore.getOrDefault(playerName, 0) + score);
            teamScore.put(teamName, teamScore.get(teamName) + score);

            if (playerScore.get(playerName) > mvpScore) {
                mvp = playerName;
                mvpScore = playerScore.get(playerName);
            }
        }

        if (teamScore.get(teamA).equals(teamScore.get(teamB))) {
            System.out.println("ended in a draw");
        } else {
            System.out.println(teamScore.get(teamA) > teamScore.get(teamB) ? teamA : teamB);
        }

        System.out.println(mvp);

    }
}



























