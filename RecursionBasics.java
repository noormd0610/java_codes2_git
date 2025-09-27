
public class RecursionBasics {

    public static int xPowN(int x, int n) {
        //1.base case
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }

        int LefthalfRes = xPowN(x, n / 2);
        int RighthalfRes = LefthalfRes;
        int Total = LefthalfRes * RighthalfRes;
        if (n % 2 == 0) {
            return Total;
        }
        return x * Total;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.out.println(xPowN(x, n));
    }
}
