package com.forms.registrationandsignin.service

import com.forms.registrationandsignin.entity.SignUpEntity
import com.forms.registrationandsignin.model.SignUpModel
import com.forms.registrationandsignin.repository.SignUpRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.sign

@Service
class SignUpServiceImpl(var signUpRepo: SignUpRepository) : SignUpService {
    override fun register(signUpModel: SignUpModel): SignUpEntity {
        val existingUser = getUser(signUpModel.username)
        if (existingUser.isPresent) throw RuntimeException("This User Already Exists")
        val newUser = SignUpEntity.createNewUser(signUpModel)
        return signUpRepo.save(newUser)
    }

    override fun getUser(name: String): Optional<SignUpEntity> {
        return signUpRepo.findByUsername(name)
    }
}