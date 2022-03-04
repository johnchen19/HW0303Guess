package com.john1119.hw0303guess

class PickSecret(var min:Int, var max:Int) {
    var secret = (min..max).random()
}