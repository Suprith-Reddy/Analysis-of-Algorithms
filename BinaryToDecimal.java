public class BinaryToDecimal {
    public static void main(String[] args) {
        String bin = "11001";
        int dec = binToDec(bin);
        System.out.println(bin); //11001
        System.out.println(dec); //25
    }
    
    //Assuming bin to be the valid input, ignored all validility checks...
    private static int binToDec(String bin) {
        int len = bin.length()-1;
        int output = 0;
        if(len<0)
            return -1;
        for(int i=0;i<bin.length();i++){
            int bit = charToInt(bin.charAt(i));

            //Exponent decreases from len-1 to 0 of BIN
            int exp = len--;
            
            //Multiplies 2^exp to the bit (1 or 0) and sums up
            output += bit*(Math.pow(2,exp));
        }
        return output;
    }

    private static int charToInt(char c) {
        //ASCII value of '0' character is 48
        //Digit characters 0-9 has ASCII values of 48-57
        //Typecasting a character to integer returns it's ASCII value
        return (int)c-48;
    }
}
