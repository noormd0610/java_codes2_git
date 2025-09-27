public class TillingPrblm {

    public static int TillingPrblm(int n){
        // 1 base case
        if(n==0||n==1){
            return 1;
        }

        //2.kaam
        int fnm1=TillingPrblm(n-1);
        int fnm2=TillingPrblm(n-2);
         return fnm1+fnm2;
    }
   public static void main(String[] args) {
    int n=4;
    System.out.println(TillingPrblm(n));
   } 
}
