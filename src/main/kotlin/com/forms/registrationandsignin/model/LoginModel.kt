package com.forms.registrationandsignin.model

//import jakarta.validation.constraints.NotEmpty
import javax.validation.constraints.NotEmpty

data class LoginModel (
    @field:NotEmpty(message = "Username is Required") val username:String,
    @field:NotEmpty(message = "please Enter a Valid Password")val password: String
)