package com.forms.registrationandsignin.model

//import jakarta.validation.constraints.NotEmpty
import javax.validation.constraints.NotEmpty

class SignUpModel {
    @field:NotEmpty(message = "Username is Required")val username =""
    @field:NotEmpty(message = "firstname is Required")val firstname = ""
    @field:NotEmpty(message = "lastname is Required")val lastname = ""
    @field:NotEmpty(message = "password is Required")val password = ""
}