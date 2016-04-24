package com.ramon.lcs.services;

import com.ramon.lcs.restInput.TheValue;
import com.ramon.lcs.utils.CommonComparators;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LongestCommonService {

    Logger logger = LogManager.getLogger(getClass());

    /**
     * Find the longest common string. The list of values are assumed not to
     * be sorted. You can sort it using the Comparator @CommonComparators.
     * This method will sort your list, so no need to sort it.
     * If it's not sorted, it won't give you good results. Also assumes all
     * the strings are more than 1 character long.
     *
     * @param args the list of strings to be compared.
     * @return the string that is in common with all the strings in the list
     */
    public List<TheValue> findLongestCommonString(List<TheValue> args)
    {
        args.sort(CommonComparators.VALUE_ALPHABETICAL_ORDER);

        List<TheValue> theResult = new ArrayList<TheValue>();

        TheValue firstValue = args.get(0);
        List<TheValue> restOfArray = args.subList(1, args.size());
        String firstString = firstValue.getValue();

        for (int i = firstString.length(); i >= 1; i--) {
            for (int j = 0; j < firstString.length(); j++) {
                int endIndex = i + j;
                if(endIndex > firstString.length())
                    continue;

                String lcs = firstString.substring(j, endIndex);
                logger.info("Is This The LCS? " + lcs);

                if(checkIfSubstringExistsInList(restOfArray,lcs))
                {
                    logger.info("Found The Lcs: " + lcs);
                    TheValue value = new TheValue();
                    value.setValue(lcs);
                    theResult.add(value);
                }
            }

            logger.info("size of the result: " + theResult.size());

            if(theResult.size() > 0) {
                theResult.sort(CommonComparators.VALUE_ALPHABETICAL_ORDER);
                return theResult;
            }
        }

        return null;

    }


    private boolean checkIfSubstringExistsInList(List<TheValue> haystack, String needle)
    {
        logger.info("haystack length: " + haystack.size());
        for (TheValue hay: haystack) {
            logger.info(hay.getValue() + "==?" + needle);
            if(hay.getValue().indexOf(needle) < 0)
                return false;
        }

        return true;
    }


}
