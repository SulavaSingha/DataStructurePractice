public class SpanPeriod {

public int[] calculateSpanPeriod(int[] a){
    int[] si =new int[a.length];
    si[0]=1;
    for(int i=1;i<a.length;i++){
        int j=i-1;
        int cnt=1;
        if(a[i]>=a[j]){
            int k=j;
            while(k>=0 && a[i]>=a[k]){
                cnt++;
                k--;
            }
        }
        si[i]= cnt;
    }
    return si;
}
}
