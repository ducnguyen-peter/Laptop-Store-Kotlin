package com.example.laptopstorekotlin.model.user

import java.io.Serializable

data class User(var id:Int?,
                var name:String?,
                var password:String?,
                var email:String?,
                var phoneNum:String?,
                var avatarLink:String?,
                var role:String?):Serializable{
    constructor():this(null, null, null, null, null, null, null)
}