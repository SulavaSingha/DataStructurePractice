public class MainClass {
    public static void main(String[] args){
        int[] input ={100,80,60,70,60,75,85};
        SpanPeriod sp=new SpanPeriod();
        int [] si=sp.calculateSpanPeriod(input);
        for(int i=0;i<si.length;i++){
            System.out.println(si[i]);
        }
    }
}
