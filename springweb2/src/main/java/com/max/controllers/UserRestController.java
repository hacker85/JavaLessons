package com.max.controllers;

import com.max.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class UserRestController {
    @GetMapping("restGet")
//    @ResponseBody
    public User restGet() {
        return new User("Max");
    }
    @PutMapping("restPut")
//    @ResponseBody
    public User user(@RequestBody User user) {
        user.setName("Mike");
        return user;
    }
    @GetMapping(value = "requestEntity", consumes = "application/json")
    public ResponseEntity<User> requestEntity() {
//        return new ResponseEntity<Error>(new Error("message", 404), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<User>(new User("Max"), HttpStatus.OK);
    }
    static class Error {
        String message;
        int errorCode;

        public Error() {
        }

        public Error(String message, int errorCode) {
            this.message = message;
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }
    }
}
