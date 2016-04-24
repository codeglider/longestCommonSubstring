package com.ramon.lcs.controllers;

import com.ramon.lcs.restInput.LeastCommonRequest;
import com.ramon.lcs.restInput.TheValue;
import com.ramon.lcs.restOutput.LeastCommonResponse;
import com.ramon.lcs.services.LongestCommonService;
import com.ramon.lcs.utils.CommonComparators;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LeastCommonController {

    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private LongestCommonService longestCommonService;

    @RequestMapping(name = "lcs", method = RequestMethod.POST)
    public ResponseEntity<LeastCommonResponse> calculateLcs(@RequestBody LeastCommonRequest lcsRequst)
    {
        List<TheValue> values = lcsRequst.getSetOfStrings();
        logger.info("Number Of Strings To Compare: " + values.size());

        List<String> stringList = new ArrayList<String>(values.size());

        for (TheValue value :  values) {
            if(value.getValue().length() < 1)
            {
                logger.error("invalid string input in list.");
                LeastCommonResponse response = new LeastCommonResponse();
                response.setLcs("One Or More Of The Input Values Were An Empty String");
                return new ResponseEntity<LeastCommonResponse>(response, HttpStatus.FAILED_DEPENDENCY);
            }
            logger.info("adding to list: " + value.getValue());
            stringList.add(value.getValue());
        }

        stringList.sort(CommonComparators.ALPHABETICAL_ORDER);

        logger.info("String list built with : " + stringList.size() + " strings.");

        String lcs = longestCommonService.findLongestCommonString(stringList.toArray(new String[0]));

        if(lcs == null)
        {
            LeastCommonResponse response = new LeastCommonResponse();
            response.setLcs("NO LCS Found. SORRY TRY AGAIN, WON'T YOU?");
            return new ResponseEntity<LeastCommonResponse>(response, HttpStatus.BAD_REQUEST);
        }

        LeastCommonResponse response = new LeastCommonResponse();
        response.setLcs(lcs);

        logger.info("Result: " + lcs);
        return new ResponseEntity<LeastCommonResponse>(response, HttpStatus.OK);
    }

}
