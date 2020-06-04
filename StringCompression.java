public class StringCompression {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        int orgLen = s.length();
        StringBuilder sb = new StringBuilder();
        
        int i=0,j=1;
        if(orgLen!=0)
            sb.append(s.charAt(i));
        while(i<orgLen && j<orgLen){
            if(s.charAt(i)!=s.charAt(j)){
                sb.append(j-i); //(j-i) is the frequency of char at i
                i = j;
                sb.append(s.charAt(i));
            }
            j++;
        }
        if(i<orgLen){
            sb.append(j-i); ////(j-i) is the frequency of char at i
        }
        //If compressed string length is less than original return original else compressed
        if(sb.length()>=orgLen)
            System.out.println(s);
        else
            System.out.println(sb.toString()); //Prints "a2b1c5a3"
    }
}
