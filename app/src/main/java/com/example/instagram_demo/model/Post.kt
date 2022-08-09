package com.example.instagram_demo.model

class Post {

    var profile:Int=0
    var fullname:String=""
    var photo:Int=0

    var photo_1:Int=0
    var photo_2:Int=0
    var photo_3:Int=0


    constructor(profile:Int, fullname:String,  photo:Int){
        this.profile=profile
        this.fullname=fullname
        this.photo=photo
    }

    constructor(profile:Int, fullname:String,  photo_1:Int,photo_2: Int,photo_3: Int){
        this.profile=profile
        this.fullname=fullname
        this.photo_1=photo_1
        this.photo_2=photo_2
        this.photo_3=photo_3
    }

    constructor(profile:Int, fullname:String,  photo_1:Int,photo_2: Int){
        this.profile=profile
        this.fullname=fullname
        this.photo_1=photo_1
        this.photo_2=photo_2
    }


}