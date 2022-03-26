package io.kodlama.Northwind.api.controllers;


import io.kodlama.Northwind.business.abstracts.UserService;
import io.kodlama.Northwind.core.entities.User;
import io.kodlama.Northwind.core.utilities.results.DataResult;
import io.kodlama.Northwind.core.utilities.results.ErrorDataResult;
import io.kodlama.Northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/users/")
public class UsersController {

    private UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("findByEmail")
    public DataResult<User> findByEmail(@RequestParam String email){
        return this.userService.findByEmail(email);
    }


    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
