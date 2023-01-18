package com.forms.registrationandsignin.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.forms.registrationandsignin.model.SignUpModel
//import jakarta.persistence.*
import org.hibernate.Hibernate
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
@Table(name="register")
data class SignUpEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    val id:Long?,
    @Column(name = "username",unique = true,nullable = false)
    val username :String,
    @Column(name = "firstname")
    val firstname :String,
    @Column(name = "lastname")
    val lastname :String,
    @Column(name = "password")
    @JsonIgnore
    var password :String

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SignUpEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , username = $username , firstname = $firstname , lastname = $lastname , password = $password )"
    }
    fun encryptedPassword(password: String){
        this.password = BCryptPasswordEncoder(8).encode(password)
    }
    companion object{

        fun createNewUser(signUpModel: SignUpModel):SignUpEntity{
            val newUser = SignUpEntity(null,signUpModel.username,signUpModel.firstname,signUpModel.lastname,signUpModel.password)
            newUser.encryptedPassword(signUpModel.password)
            return newUser
        }
    }
}

