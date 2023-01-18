package com.forms.registrationandsignin.service

import com.forms.registrationandsignin.entity.SignUpEntity
import com.forms.registrationandsignin.model.SignUpModel
import java.util.Optional
import javax.swing.text.html.parser.Entity

interface SignUpService {
    fun register(signUpModel:SignUpModel):SignUpEntity
    fun getUser(name:String):Optional<SignUpEntity>
}