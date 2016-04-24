package com.ramon.lcs.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LongestCommonService {

    Logger logger = LogManager.getLogger(getClass());

    /**
     * Find the longest common string. This string is assumed to be sorted.
     * If it's not sorted, it won't give you good results. Also assumes all
     * the strings are more than 1 character long.
     *
     * @param args the list of strings to be compared.
     * @return the string that is in common with all the strings in the list
     */
    public String findLongestCommonString(String [] args)
    {
        String lcs;

        String firstString = args[0];
        String[] restOfArray = Arrays.copyOfRange(args, 1, args.length);

        for (int i = firstString.length(); i >= 1; i--) {
            for (int j = 0; j < firstString.length(); j++) {
                int endIndex = i + j;
                if(endIndex > firstString.length())
                    continue;

                lcs = firstString.substring(j, endIndex);
                logger.info("Is This The LCS? " + lcs);

                if(checkIfSubstringExistsInList(restOfArray,lcs))
                {
                    logger.info("Found The Lcs: " + lcs);
                    return lcs;
                }

                logger.info(lcs + " is NOT the lcs");
            }
        }

        return null;

    }


    private boolean checkIfSubstringExistsInList(String[] haystack, String needle)
    {
        logger.info("haystack length: " + haystack.length);
        for (String hay: haystack) {
            logger.info(hay + "==?" + needle);
            if(hay.indexOf(needle) < 0)
                return false;
        }

        return true;
    }


}
