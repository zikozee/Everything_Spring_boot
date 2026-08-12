package com.zee.ebs.controllers;


import com.zee.ebs.dto.PaymentRequest;
import com.zee.ebs.dto.SampleRequest;
import com.zee.ebs.dto.SampleResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Jul, 2026
 */

@Validated
@Slf4j
@RestController
@RequestMapping(path = "sample")
public class SampleController {

    @PostMapping
    public ResponseEntity<SampleResponse> createObject(@RequestBody @Valid SampleRequest sampleRequest){

        return ResponseEntity.ok(
                new SampleResponse(
                        sampleRequest.fullName(),
                        LocalDate.of(1995, Month.DECEMBER, 20),
                        sampleRequest.age()
                )
        );
    }

    @GetMapping(path = "/{fullName}")
    public ResponseEntity<SampleResponse> getOne(@PathVariable(value = "fullName") String fullName){

        return ResponseEntity.ok(
                new SampleResponse(
                        fullName,
                        LocalDate.of(1995, Month.DECEMBER, 20),
                        30
                )
        );
    }

    @GetMapping(path = "get-single")
    public ResponseEntity<SampleResponse> getSingle(@RequestParam(value = "age") int age){

        return new ResponseEntity<>(new SampleResponse(
                "Ezekiel Eromosei",
                LocalDate.of((2026-age), Month.DECEMBER, 20),
                30
        ), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SampleResponse> putSingle(@RequestBody SampleRequest sampleRequest){

        return ResponseEntity.ok(
                new SampleResponse(
                        sampleRequest.fullName(),
                        LocalDate.of(1995, Month.DECEMBER, 20),
                        sampleRequest.age()
                )
        );
    }

    @PatchMapping
    public ResponseEntity<SampleResponse> patchSingle(@RequestBody SampleRequest sampleRequest){

        return ResponseEntity.ok(
                new SampleResponse(
                        sampleRequest.fullName(),
                        LocalDate.of(1995, Month.DECEMBER, 20),
                        30
                )
        );
    }

    @DeleteMapping
    public void deleteSingle(@RequestParam(value = "age") int age){
        log.info("deleted record with age: {}", age);
    }


    @PostMapping(path = "pay")
    public ResponseEntity<SampleResponse> pay(@RequestBody @Valid PaymentRequest paymentRequest){


        return ResponseEntity.ok(
                new SampleResponse(
                        paymentRequest.getMerchantName(),
                        LocalDate.of(1995, Month.DECEMBER, 20),
                        52
                )
        );
    }
}
