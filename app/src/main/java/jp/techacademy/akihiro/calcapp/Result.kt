package jp.techacademy.akihiro.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.akihiro.calcapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val ans = intent.getDoubleExtra("ans",0.0)

        textView.text = ans.toString()
    }
}