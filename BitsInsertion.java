public class BitsInsertion {
    public static void main(String[] args) {
    /* Problem 5.1 CTCI */
        int N = 1024;
        int M = 19;
        
        int len = Integer.toBinaryString(-1).length(); //32/64-bit length
        int j = 6, i = 2;

        int N_mask = (-1 << (j+1)) | (-1 >>> (len - i)); //Arithmetic left shift for first bits(most significant) and logical right shift for last bits(least significant)
        int M_mask = M << i; // Appending i bits of 0 at last to M to insert into N

        //Finally AND N_mask with N and OR resultant with M_mask
        System.out.println(Integer.toBinaryString((N_mask & N) | M_mask));
    }
}
