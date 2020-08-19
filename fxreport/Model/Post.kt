package com.example.fxreport.Model

class Post {

    private  var postid : String =""
    private  var postimage : String =""
    private  var publisher : String =""
    private  var desciption : String =""

    constructor()


    constructor(postid: String, postimage: String, publisher: String, desciption: String) {
        this.postid = postid
        this.postimage = postimage
        this.publisher = publisher
        this.desciption = desciption
    }


    fun getPostid() : String{
        return  postid
    }

    fun getPostimage() : String{
        return  postimage
    }

    fun getPublisher() : String{
        return  publisher
    }

    fun getDescription() : String{
        return  desciption
    }

    fun setPostid(postid : String)
    {
        this.postid = postid
    }

    fun setPostimage(postimage: String)
    {
        this.postimage = postimage
    }
    fun setPublisher(publisher : String)
    {
        this.publisher = publisher
    }
    fun setDescription(desciption : String)
    {
        this.desciption = desciption
    }


}