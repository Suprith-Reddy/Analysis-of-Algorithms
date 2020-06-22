public class ConversionFlips {
    public static void main(String[] args) {
        int A = 29; //11101
        int B = 15; //01111
        int flips = 0;
        int len;
        if(A>B)
            len = getLen(A);
        else
            len = getLen(B);
        for(int i=0;i<len;i++){
            int bitA = getBit(A, i);
            int bitB = getBit(B, i);
            if(bitA != bitB)
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
