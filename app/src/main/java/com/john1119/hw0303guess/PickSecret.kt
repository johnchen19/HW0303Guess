package com.john1119.hw0303guess

class PickSecret() {
    var min = 0
    var max = 0
    var secret :Int= 0
    var counter = 0
    var end=false
    var message = ""
    init {
        reset()
    }
    fun reset(){
        min=1
        max=100
        secret =(min..max).random()
        counter=0
        end=false
        message="1 to 100"
    }
    fun guess(number:Int):String{
        counter++
        message=if(number>secret) {
            max=number
            "Smaller,$min to $number"
        }
        else if(number<secret) {
            min=number
            "Bigger,$number to $max"
        }
        else {
            end = true
            "You got it"
        }
        return message
    }
}
