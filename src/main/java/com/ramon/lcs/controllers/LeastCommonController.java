package com.ramon.lcs.controllers;

import com.ramon.lcs.restInput.LeastCommonRequest;
import com.ramon.lcs.restInput.TheValue;
import com.ramon.lcs.restOutput.LeastCommonResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class LeastCommonController {

    Logger logger = LogManager.getLogger(getClass());

    @RequestMapping(name = "lcs", method = RequestMethod.POST)
    public ResponseEntity<LeastCommonResponse> calculateLcs(@RequestBody LeastCommonRequest lcsRequst)
    {
        List<TheValue> values = lcsRequst.getSetOfStrings();
        logger.info("Number Of Strings To Compare: " + values.size());

        for (TheValue value :  values) {
            logger.info(value.getValue());
        }

        return new ResponseEntity<LeastCommonResponse>(HttpStatus.OK);
    }

}
