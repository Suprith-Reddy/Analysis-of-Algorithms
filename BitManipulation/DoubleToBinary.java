public class DoubleToBinary {
/* Problem 5.2 CTCI */
    public static void main(String[] args) {
        double r = 0.72;
        String s = Double.toString(r);
        String[] sList = s.split("\\.");
        if(sList.length != 2){
            System.out.println("ERROR");
            return;
        }
        int first, second;
        try{
            first = Integer.parseInt(sList[0]);
            second = Integer.parseInt(sList[1]);

            String fs = Integer.toBinaryString(first);
            String ss = Integer.toBinaryString(second);

            if(fs.length()+ss.length() > 31){
                System.out.println("ERROR");
            }
            else{
                System.out.println(fs+"."+ss); //0.1001000
            }
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
    }
}
