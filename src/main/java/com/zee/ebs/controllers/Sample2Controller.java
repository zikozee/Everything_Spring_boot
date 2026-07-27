package com.zee.ebs.controllers;


import com.zee.ebs.dto.SampleRequest;
import com.zee.ebs.dto.SampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Jul, 2026
 */

@Slf4j
@RestController
@RequestMapping(path = "sample2")
public class Sample2Controller {

    @RequestMapping(method = RequestMethod.POST)
    public SampleResponse createObject(@RequestBody SampleRequest sampleRequest){

        return new SampleResponse(
                sampleRequest.fullName(),
                LocalDate.of(1995, Month.DECEMBER, 20),
                sampleRequest.age()
        );
    }

    @RequestMapping(method = RequestMethod.GET, path = "{fullName}")
    public SampleResponse getOne(@PathVariable(value = "fullName") String fullName){

        return new SampleResponse(
                fullName,
                LocalDate.of(1995, Month.DECEMBER, 20),
                30
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "get-single")
    public SampleResponse getSingle(@RequestParam(value = "age") int age){

        return new SampleResponse(
                "Ezekiel Eromosei",
                LocalDate.of((2026-age), Month.DECEMBER, 20),
                30
        );
    }


    @RequestMapping(method = RequestMethod.PUT)
    public SampleResponse putSingle(@RequestBody SampleRequest sampleRequest){

        return new SampleResponse(
                sampleRequest.fullName(),
                LocalDate.of(1995, Month.DECEMBER, 20),
                sampleRequest.age()
        );
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public SampleResponse patchSingle(@RequestBody SampleRequest sampleRequest){

        return new SampleResponse(
                sampleRequest.fullName(),
                LocalDate.of(1995, Month.DECEMBER, 20),
                30
        );
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSingle(@RequestParam(value = "age") int age){
        log.info("deleted record with age: {}", age);
    }
}
