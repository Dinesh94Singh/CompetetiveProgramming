package com.company.codingscales.interviews.goldmansachs;

public class TagIdentificationNumber {
    static int numOfIds(String pool) {
        if (pool == null || pool.length() < 11)
            return 0;
        int maxPossibleIds = pool.length() / 11;
        int countOf8s = 0;

        for(char ch : pool.toCharArray())
            if (ch == '8')
                countOf8s++;

       if (countOf8s == 0)
           return 0;
       if (countOf8s >= maxPossibleIds)
           return maxPossibleIds;
       return countOf8s;
    }
}
