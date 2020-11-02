package com.company.codingscales.interviews.amazon;

public class FreshPromotion {
    // similar to 392. Is Subsequence
    // U can ignore if it is "anything"
    public static int winPrize(final String[][] codeList, final String[] shoppingCart) {
        if (codeList == null || codeList.length == 0)
            return 1;
        if (shoppingCart == null || shoppingCart.length == 0)
            return 0;

        int i = 0, j = 0;
        while (i < codeList.length && j + codeList[i].length <= shoppingCart.length) {
           boolean match = true;
           for(int k = 0; k < codeList[i].length; k++) {
               if (!codeList[i][k].equals("anything") && !shoppingCart[j + k].equals(codeList[i][k])) {
                   match = false;
                   break;
               }
           }

           if (match) {
               j += codeList[i].length;
               i++;
           } else {
               j++;
           }
        }

        return (i == codeList.length) ? 1 : 0;
    }
}
