package ch.demo.testbindinglayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = TestFragment.newInstance("111")

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.frameLayout, fragment, "TEST")
        transaction.commit()
    }
}