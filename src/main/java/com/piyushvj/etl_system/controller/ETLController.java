package com.piyushvj.etl_system.controller;

import com.piyushvj.etl_system.service.ETLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/etl")
public class ETLController {

    @Autowired
    ETLService etlService;


    @RequestMapping(value = "/perform", method = RequestMethod.POST, consumes = "application/json")

    public ResponseEntity<String> doPerform(@RequestBody (required = true)Map<String, String> data){
        System.out.println(data);
        System.out.println(data.size());

        ResponseEntity<String> responseEntity;
        String finalData;
        HttpStatus status;

        if(data.size()>0) {
            String inputFileName = data.get("inputFileName");
            String transformTo = data.get("transformTo");
            String outputFileName = data.get("outputFileName");
            finalData = etlService.doEtlOperation(inputFileName, transformTo, outputFileName);
            status = HttpStatus.OK;
        }else {
            finalData="";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(finalData, status);
    }
}
