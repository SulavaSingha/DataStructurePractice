import java.util.Arrays;

public class SparseArrays {
    static int[] matchingStrings(String[] strings, String[] queries) {
        Arrays.sort(strings);
        Arrays.sort(queries);
        int[] a = new int[queries.length];
        int count = 0;
        int k=0;
        for (int i = 0; i < queries.length; i++) {
            count = 0;
            String q = queries[i];
            for (int j = k; j < strings.length;j++) {
                String s = strings[j];
                if (q.equals(s)) {
                    count++;
                    a[i] = count;
                    k=j+1;
                    continue;

                }

                    break;

            }
        }
        return a;
    }


    public static void main(String[] args) {
        String[] strings=new String[]{"ab","aba","abcd","xyz","aba","abacd","ab"};
        String[] queries = new String[]{"ab","aba","xyz"};
int [] a=SparseArrays.matchingStrings(strings,queries);
for(int i=0;i<a.length;i++){
    System.out.println(a[i]);
}

    }
}
