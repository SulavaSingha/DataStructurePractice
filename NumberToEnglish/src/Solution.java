class Solution {
    public String ones(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    public String moreThan20(int num){
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
    public String twenties(int num){
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    public String twoDigits(int num){
        StringBuilder result= new StringBuilder();
        int tens= num/10;
        int tenner=tens*10;
        int rest=(num-tenner)+tenner;
        int lastones=num-tenner;
        if(rest!=0){
            if(rest<10){
                result.append(ones(rest));
            }
            else if(rest<20 && rest>=10){
                result.append(twenties(rest));
            }
            else if(rest>=20) {
                result.append(moreThan20(tens));
                result.append(" ");
                result.append(ones(lastones));
            }
        }
        return result.toString();
    }
    public String threeDigits(int num){
        StringBuilder result= new StringBuilder();
        int hundred= num/100;
        int rest= num-(hundred*100);
        if(hundred!=0 && hundred <10){
            result.append(ones(hundred));
        }
        else if(hundred >10){
            result.append(twoDigits(hundred));
        }
        result.append(" ");
        result.append("Hundred");

        if(rest!=0){
            if(result.length()!=0){
                result.append(" ");
            }
            result.append(twoDigits(rest));
        }
        return result.toString();
    }
    public String numberToWords(int num) {
        //find out max billion , million and thousand
        int billion = num/1000000000;
        int million= num/1000000;
        int thousand= num/1000;
        int rest= num-billion*1000000000 -million*1000000- thousand*1000;
        StringBuilder result= new StringBuilder();
        if(billion!=0){
            result.append(threeDigits(billion));
            result.append(" ");
            result.append("Billion");
        }
        if(million!=0){
            if(result.length()!=0)
                result.append(" ");
            result.append(threeDigits(million));
            result.append(" ");
            result.append("Million");

        }
        if(thousand!=0){
            if(result.length()!=0){
                result.append(" ");
            }
            result.append(threeDigits(thousand));
            result.append(" ");
            result.append("Thousand");
        }

        if(rest!=0){
            if(result.length()!=0){
                result.append(" ");
            }
            result.append(threeDigits(rest));
        }
        return result.toString();
    }
    public static  void main(String [] args){
        Solution sol= new Solution();
        sol.numberToWords(20);
    }
}