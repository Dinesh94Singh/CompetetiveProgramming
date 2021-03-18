package com.company.codingscales.leetcode.concepts.design;

public class IntegerToEnglish {
    public String one(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    public String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

    private static int ONE_BILLION = (int) Math.pow(10, 9);
    private static int ONE_MILLION = (int) Math.pow(10, 6);
    private static int ONE_THOUSAND = (int) Math.pow(10, 3);
    private static int ONE_HUNDRED = (int) Math.pow(10, 2);
    private static int TEN = (int) Math.pow(10, 1);

    public String two(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return one(num);
        else if (num < 20)
            return twoLessThan20(num);
        else {
            int noOfTens = num / TEN;
            int rest = num - noOfTens * TEN;
            if (rest != 0)
                return ten(noOfTens) + " " + one(rest);
            else
                return ten(noOfTens);
        }
    }

    public String three(int num) {
        int noOfHundreds = num / ONE_HUNDRED;
        int rest = num - noOfHundreds * ONE_HUNDRED;
        String res = "";
        if (noOfHundreds * rest != 0)
            res = one(noOfHundreds) + " Hundred " + two(rest);
        else if ((noOfHundreds == 0) && (rest != 0))
            res = two(rest);
        else if ((noOfHundreds != 0) && (rest == 0))
            res = one(noOfHundreds) + " Hundred";
        return res;
    }


    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int noOfBillions = num / ONE_BILLION ;
        int noOfMillions = (num - noOfBillions * ONE_BILLION) / ONE_BILLION;
        int noOfThousands = (num - noOfBillions * ONE_BILLION -  noOfMillions * ONE_MILLION) / ONE_THOUSAND;
        int rest = num - noOfBillions * ONE_BILLION -  noOfMillions * ONE_MILLION - noOfThousands * ONE_THOUSAND;

        String result = "";
        if (noOfBillions != 0)
            result = three(noOfBillions) + " Billion";
        if ( noOfMillions != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three( noOfMillions) + " Million";
        }
        if (noOfThousands != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(noOfThousands) + " Thousand";
        }
        if (rest != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(rest);
        }
        return result;
    }
}
