package com.john1119.hw0303guess

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.john1119.hw0303guess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

//    var min = 1
//    var max = 100
//    var pick=PickSecret(min,max)
//    var secret=pick.secret
//    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
}
    var pick=PickSecret()
    fun guess(view: View){
        var number=binding.edNumber.text.toString().toInt()
        var message=pick.guess(number)
        AlertDialog.Builder(this)
            .setTitle("guess")
            .setMessage(message)
            .setPositiveButton("OK"){d,w->
                if(pick.end==true) {
                    pick.reset()
                    binding.tvRange.text = pick.message
                    binding.tvCounter.text=pick.counter.toString()
                }
            }
            .show()
        binding.tvRange.text = pick.message
        binding.tvCounter.text=pick.counter.toString()
    }

}