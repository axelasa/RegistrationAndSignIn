package com.forms.registrationandsignin.controllerExceptionHandlers

import com.forms.registrationandsignin.model.ApiResponse
import com.forms.registrationandsignin.model.LoginModel
import com.forms.registrationandsignin.model.SignUpModel
import com.forms.registrationandsignin.service.SignUpService
//import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("register")
class SignUpController(var registerService:SignUpService) {
    @PostMapping
    fun createUser(@Valid @RequestBody signup:SignUpModel):ResponseEntity<Any>{
       val newUser = registerService.register(signup)
        return ResponseEntity(ApiResponse(HttpStatus.OK.value(),"User created successfully",newUser),HttpStatus.OK)
    }
    @PostMapping("signIn")
    fun login(@Valid @RequestBody loginModel:LoginModel):ResponseEntity<Any>{
        val registeredUser = registerService.getUser(loginModel.username)
        if (registeredUser.isEmpty){
            return ResponseEntity(ApiResponse(HttpStatus.NOT_FOUND.value(),"User not Found",null),HttpStatus.NOT_FOUND)
        }
        val user = registeredUser.get()
        if (user.password != loginModel.password){
            return ResponseEntity(ApiResponse(HttpStatus.UNAUTHORIZED.value(),"Wrong password",null),HttpStatus.UNAUTHORIZED)
        }
        return ResponseEntity(ApiResponse(HttpStatus.OK.value(),"success",user),HttpStatus.OK)
    }
}