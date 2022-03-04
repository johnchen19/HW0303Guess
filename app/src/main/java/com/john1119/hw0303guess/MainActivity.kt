package com.john1119.hw0303guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.john1119.hw0303guess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    var min = 1
    var max = 100
    var pick=PickSecret(min,max)
    var secret=pick.secret

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun guess(view:View) {
        println(secret)
        var number = binding.edNumber.text.toString().toInt()
        if (secret > number) {
            min = number
            binding.tvRange.setText("$min to $max")
            AlertDialog.Builder(this)
                .setTitle("result")
                .setMessage("Bigger,$min to $max")
                .setPositiveButton("OK", null)
                .show()
        } else if (secret < number) {
            max = number
            binding.tvRange.setText("$min to $max")
            AlertDialog.Builder(this)
                .setTitle("result")
                .setMessage("Smaller,$min to $max")
                .setPositiveButton("OK", null)
                .show()
        } else {
            binding.tvRange.setText("The secret number is $secret")
            AlertDialog.Builder(this)
                .setTitle("result")
                .setMessage("You got it,the secret number is $number")
                .setPositiveButton("Play Again", null)
                .show()
        }
    }
    fun repick(view: View){
        min=1
        max=100
        binding.tvRange.setText("$min to $max")
        pick= PickSecret(min,max)
        secret=pick.secret
        println(secret)
    }

}