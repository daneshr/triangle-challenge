package com.tradeshift.controller.rest;

import com.tradeshift.exception.exception.ShapeNotSupportedException;
import com.tradeshift.service.TriangleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/shape")
@Api(value = "Shape Type Determination")
public class ShapeController {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private TriangleService triangleService;

    @ApiOperation(value = "triangle type determination", consumes = "tree sides of a triangle , sideA, sideB, sideC",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Successful"),
            @ApiResponse(code = 400, message = "Problem in inputs")

    })
    @GetMapping("/triangle/{sideA}/{sideB}/{sideC}")
    public ResponseEntity<String> determineTriangleType(@PathVariable int sideA, @PathVariable int sideB, @PathVariable int sideC) {
        logger.info("determining the type of a triangle with sideA: {}, sideB: {}, sideC: {} ", sideA, sideB, sideC);
        String result = triangleService.getType(sideA, sideB, sideC);
        logger.info("the type is: {}", result);
        return ResponseEntity.accepted().body(result);
    }

    @ExceptionHandler({IllegalArgumentException.class, ShapeNotSupportedException.class})
    public ResponseEntity<String> handleBusinessException(Exception ex) {
        logger.warn(ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
