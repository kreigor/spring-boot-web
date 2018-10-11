package io.kreiger.web.home.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.kreiger.web.home.model.APIInfo;

@RestController
@RequestMapping("/api")
public class HomeRestController {
    private final Logger logger = LogManager.getLogger(getClass());

    @GetMapping("/")
    public ResponseEntity<APIInfo> info() {
        logger.error("Error message");
        logger.debug("Debug Message");
        logger.info("Info Message");
        return new ResponseEntity<>(new APIInfo(), HttpStatus.OK);
    }
}
