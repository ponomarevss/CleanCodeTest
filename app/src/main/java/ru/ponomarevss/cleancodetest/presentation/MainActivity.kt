package ru.ponomarevss.cleancodetest.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.ponomarevss.cleancodetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var vb: ActivityMainBinding? = null

    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(applicationContext))[MainViewModel::class.java]

        val btnSend = vb?.btnSend
        val btnReceive = vb?.btnReceive
        val tvData = vb?.tvData
        val etData = vb?.etData

        vm.resultLive.observe(this, {text ->
            tvData?.text = text
        })

        btnSend?.setOnClickListener {
            vm.save(etData?.text.toString())
        }

        btnReceive?.setOnClickListener {
            vm.load()
        }
    }
}