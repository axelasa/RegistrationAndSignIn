package com.forms.registrationandsignin.repository

import com.forms.registrationandsignin.entity.SignUpEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SignUpRepository:JpaRepository<SignUpEntity,Long> {
    fun findByUsername(name:String):Optional<SignUpEntity>
}