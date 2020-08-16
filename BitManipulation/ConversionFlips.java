public class ConversionFlips {
    /* Problem 5.6 CTCI */
    public static void main(String[] args) {
        int A = 29; //11101
        int B = 15; //01111
        int flips = 0;

        int res = A ^ B; //XOR operation
        int len = getLen(res);

        for(int i=0;i<len;i++){
            if(getBit(res, i) != 0)
                flips++;
        }
        System.out.println(flips); //2
    }

    private static int getBit(int a, int i) {
        return a & (1<<i);
    }

    private static int getLen(int a) {
        //Length of the binary string
        return (int) (Math.log(a)/Math.log(2) + 1);
    }
}
