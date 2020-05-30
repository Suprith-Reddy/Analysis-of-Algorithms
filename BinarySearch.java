public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8};
        int target = -1; //returns false 5: returns true
        boolean output = binarySearch(input, 0, input.length-1, target);
        System.out.println(output);
    }

    private static boolean binarySearch(int[] input, int l, int h, int t) {
        boolean output = false;
        if(l<=h){
            int m = (l+h)/2;
            if(input[m]==t)
                return true;
            else if(input[m]<t)
                output = binarySearch(input, m+1, h, t);
            else
                output = binarySearch(input, 0, m-1, t);
        }
        return output;
    }
}
