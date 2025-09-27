
public class TowerHonai {

    public static void tower(int n, String S, String H, String D) {

        //base case
        if (n == 1) {
            System.out.println(S + " TO " + D);
            return;
        }
        tower(n - 1, S, D, H);
        System.out.println(S + " TO " + D);
        tower(n-1 , H, S, D);

    }

    public static void main(String[] args) {
        int n = 2;
        String S = "SOURCE";
        String H = "HELPER";
        String D = "DESTINATION";
        tower(3, S, H, D);
    }
}
