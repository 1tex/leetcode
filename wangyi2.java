//在《天谕手游》生死场的玩法中，玩家在一个平面区域里进行战斗，玩家可以通过草丛隐身或buff隐身来躲避敌人的攻击，其中草丛隐身只对不同阵营的玩家有效，且只对当前草丛外的玩家有效，即在没有隐身buff的前提下，不同阵营的玩家，在任意同一个草丛互相可见。而buff隐身则对所有玩家都有效，且优先级高于草丛隐身。草丛的区域由策划划定圆形或者矩形确定。现在给出n个玩家的位置、阵营和是否拥有隐身buff的信息，以及m个图形的位置信息。询问某个玩家a是否能够看见另一个玩家b。
//
//
//
//        注：1.当玩家在草丛边上也算在草丛内
//
//        2. 草丛互相可能重叠，只要在任意一个草丛中就相互可见，例如 a玩家与b玩家不同阵营且没有隐身buff，a玩家在草丛1，2中，b玩家在草丛2，3中，a和b玩家相互可见，因为a,b玩家都在草丛2中。
//
//        输入描述
//
//        第一行输入三个正整数n,m和q (2<= n <= 1000, 1 <=m <= 100, 1 <= q <= 1000)，表示一共有n个玩家，m个图形，q个询问。
//
//        接下来n行每行有四个数， 两个数x和y, (-10000 <=x , y <=10000) ,表示当前玩家在场景中的二维坐标，两个正整数b和c,(0<= b <=1,  0<= c <=1000) 分别表示当前玩家是否拥有隐身buff (0表示没有，1表示有) 和对应的阵营。
//
//        接下来m组数据，每组数据表示一个图形草丛，每组数据第一行输入一个正整数type
//
//        (0 <= type <= 1)，0表示该草丛是圆形草丛，1表示该草丛是矩形草丛。如果是圆形草丛，接下来包含一行数据，数据有3个数cx和cy和cr分别表示圆形的圆心和半径(-10000 <= cx, cy <=10000), (0 < cr <= 10000) ；如果是矩形草丛，接下来包含4行数据，顺时针表示矩形的4个点 ，每行数据有两个数dx和dy,(-10000 <= dx, dy <=10000)，矩形平行于坐标轴。
//
//        最后输入q行，每行有2个正整数q1和q2(1<= q1, q2 <= n, q1 != q2)，表示询问第q1个玩家能否看到第q2个玩家。
//
//
//
//        输出描述
//
//        对于每一个询问，输出0或者1。一共q行，0表示看不见，1表示看得见。
//
//        示例1
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//        输入
//        复制
//        4 3 4
//        0 0 0 1
//        1 1 0 2
//        3 0 1 3
//        1.5 0 0 2
//        1
//        0 0
//        0 1
//        1 1
//        1 0
//        1
//        1 0
//        1 1
//        2 1
//        2 0
//        0
//        3 0 1
//        3 4
//        2 4
//        4 1
//        1 2
//        输出
//        复制
//        0
//        1
//        0
//        1








import java.util.Scanner;

public class wangyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Player[] players = new Player[n];
        Shape[] shapes = new Shape[m];

        for (int i = 0; i < n; i++) {
            players[i] = new Player(sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 0) {
                shapes[i] = new Circle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            } else {
                shapes[i] = new Rectangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            }
        }

        for (int i = 0; i < q; i++) {
            int q1 = sc.nextInt() - 1;
            int q2 = sc.nextInt() - 1;
            System.out.println(canSee(players[q1], players[q2], shapes) ? 1 : 0);
        }
    }

    static boolean canSee(Player a, Player b, Shape[] shapes) {
        if (a.buff == 1 || b.buff == 1) return false;

        boolean diffCamp = a.camp != b.camp;

        for (Shape shape : shapes) {
            if (shape.isInside(a) && shape.isInside(b)) {
                return !diffCamp;
            }
        }

        return true;
    }
}

class Player {
    double x, y;  // Changed to double
    int buff, camp;

    Player(double x, double y, int buff, int camp) {
        this.x = x;
        this.y = y;
        this.buff = buff;
        this.camp = camp;
    }
}

interface Shape {
    boolean isInside(Player p);
}

class Circle implements Shape {
    double x, y, r;  // Changed to double

    Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public boolean isInside(Player p) {
        return (p.x - x) * (p.x - x) + (p.y - y) * (p.y - y) <= r * r;
    }
}

class Rectangle implements Shape {
    double x1, y1, x2, y2;  // Changed to double

    Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
    }

    @Override
    public boolean isInside(Player p) {
        return p.x >= x1 && p.x <= x2 && p.y >= y1 && p.y <= y2;
    }
}








