package com.example.fxreport.Model

class User {

    private  var username: String = ""
    private  var fullname: String = ""
    private  var bio: String = ""
    private  var image: String = ""
    private  var uid: String = ""



     constructor()


    constructor(username: String,fullname: String ,bio: String ,image: String, uid: String )
    {
        this.username = username
        this.fullname = fullname
        this.bio = bio
        this.image = image
        this.uid = uid
     }

     fun getUsername(): String
     {
         return  username
     }

     fun setUsername(username : String)
     {
         this.username = username
     }
//2
    fun getFullname(): String
    {
        return  fullname
    }

    fun setFullname(fullname : String)
    {
        this.fullname = fullname
    }


    //3
    fun getBio(): String
    {
        return  bio
    }

    fun setBio(bio : String)
    {
        this.bio = bio
    }

    //4
    fun getImage(): String
    {
        return  image
    }

    fun setImage(image : String)
    {
        this.image = image
    }
    //5
    fun getUID(): String
    {
        return  uid
    }

    fun setUID(uid : String)
    {
        this.uid = uid
    }


}