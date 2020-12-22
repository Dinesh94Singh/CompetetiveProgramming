package com.company.codingscales.interviews.amazon;

public class AmazonFreshPromotion {
    public int isWinner(String[][] codeList, String[] shoppingCart) {
        int index = 0;
        int codeIndex = 0;
        int newIndex = index;
        int codeWordIndex = 0;
        while (codeIndex < codeList.length && newIndex < shoppingCart.length) {
            if (isMatched(shoppingCart[newIndex], codeList[codeIndex][codeWordIndex])) {
                newIndex++;
                codeWordIndex++;
                if (codeWordIndex == codeList[codeIndex].length) {
                    codeIndex++;
                    index = newIndex;
                    codeWordIndex = 0;
                }
            } else {
                index++;
                newIndex = index;
                codeWordIndex = 0;
            }
        }

        return codeIndex == codeList.length ? 1 : 0;
    }

    private static boolean isMatched(String source, String target) {
        return "anything".equals(target) || target.equals(source);
    }
}
