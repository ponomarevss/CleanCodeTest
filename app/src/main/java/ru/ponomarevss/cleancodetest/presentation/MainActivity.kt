package ru.ponomarevss.cleancodetest.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ponomarevss.cleancodetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var vb: ActivityMainBinding? = null

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        Log.e("AAA", "Activity created")

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