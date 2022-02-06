package jp.techacademy.akihiro.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import jp.techacademy.akihiro.calcapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMultiple.setOnClickListener(this)
        binding.btnDivied.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        // 空文字バリデーション
        if (editText1.text.toString() == "" || editText2.text.toString() == "") {
            Snackbar.make(v, "値を入力してください。", Snackbar.LENGTH_SHORT).show()
            //return
        }

        if (editText1.text.isNotEmpty() || editText2.text.isNotEmpty()) {
            val num01: Double = binding.editText1.text.toString().toDouble()
            val num02: Double = binding.editText2.text.toString().toDouble()
            var ans: Double = 0.0

            when (v.id) {
                R.id.btnAdd      -> ans = num01 + num02
                R.id.btnSub      -> ans = num01 - num02
                R.id.btnMultiple -> ans = num01 * num02
                R.id.btnDivied   -> ans = num01 / num02
            }

            val intent = Intent(this, Result::class.java)
            intent.putExtra("ans", ans)
            startActivity(intent)
        }
    }
}
