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
import java.util.Arrays;
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

        List<TheValue> result = longestCommonService.findLongestCommonString(values);

        LeastCommonResponse response = new LeastCommonResponse();
        response.setResults(result);

        return new ResponseEntity<LeastCommonResponse>(response, HttpStatus.OK);
    }

}
