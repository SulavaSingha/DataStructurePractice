public class Solutions {
    static int countingValleys(int n, String s) {
    char[] ch= s.toCharArray();
    int level=0;

    for(char c: ch ){
        if(c=='U'){
           level=level+1;
        }
        else if(c=='D'){
           level=level-1;
        }
Math.min
    }
 return level;
}


    public static void main(String[] args)  {
      String s="UDDDUDUU";

        int result = countingValleys(s.length(), s);


    }
}

