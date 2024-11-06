package infor.c14220016.fragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var angka = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val mFragmentManager = supportFragmentManager
        val mfragment1 = fragment1()
        val mfragment2 = fragment2()
        val mfragment3 = fragment3()

        mFragmentManager.findFragmentByTag(fragment1::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .add(R.id.mainFrame, mfragment1, fragment1::class.java.simpleName)
            .commit()

        val texts = arrayOf(
            mfragment1.view?.findViewById(R.id.tv1),
            mfragment2.view?.findViewById<TextView>(R.id.tv2),
            mfragment3.view?.findViewById<TextView>(R.id.tv3),
        )

        val _btn1 = findViewById<Button>(R.id.to1)
        val _btn2 = findViewById<Button>(R.id.to2)
        val _btn3 = findViewById<Button>(R.id.to3)

        _btn1.setOnClickListener {
            val f = fragment1()
            val mbundle = Bundle()
            angka -=1
            mbundle.putString("DATA", angka.toString())
            f.arguments = mbundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrame, f, fragment1::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        _btn2.setOnClickListener {
            val f = fragment2()
            val mbundle = Bundle()
            angka -=2
            mbundle.putString("DATA", angka.toString())
            f.arguments = mbundle


            mFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrame, f, fragment2::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        _btn3.setOnClickListener {
            val f = fragment3()
            val mbundle = Bundle()
            angka -= 3
            mbundle.putString("DATA", angka.toString())
            f.arguments = mbundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrame, f, fragment3::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object{
        var x = 0
    }
}