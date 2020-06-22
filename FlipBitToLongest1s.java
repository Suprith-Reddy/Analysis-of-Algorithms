public class FlipBitToLongest1s {
/* Problem 5.3 CTCI */
    public static void main(String[] args) {
        int num = 1775; //11011101111
        int max = Integer.MIN_VALUE;
        int len = Integer.toBinaryString(num).length();
        int count = 0, first, next = 0;

        for (int i=0; i<len; i++){
            int bit = num & (1<<i); //get bit at i
            if(bit != 0)
                count++;
            else{
                first = next;
                next = count;
                if(first+next > max)
                    max = first + next;
                count = 0;
            }
        }

        System.out.println(max+1); //8 longest 1s sequence
    }
}
