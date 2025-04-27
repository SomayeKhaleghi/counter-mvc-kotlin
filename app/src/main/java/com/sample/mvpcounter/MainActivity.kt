package com.sample.mvpcounter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.sample.mvpcounter.presenter.CounterPresenter
import com.sample.mvpcounter.view.CounterView

/**
 * Activity that displays the Counter screen and acts as the View in MVP.
 */
class CounterActivity : ComponentActivity(), CounterView {

    private lateinit var presenter: CounterPresenter
    private lateinit var tvCounter: TextView
    private lateinit var btnIncrement: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        initViews()
        setupListeners()
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }

    private fun initViews() {
        tvCounter = findViewById(R.id.tvCounter)
        btnIncrement = findViewById(R.id.btnIncrement)
    }

    private fun setupListeners() {
        btnIncrement.setOnClickListener {
            presenter.onIncrementClicked()
        }
    }

    override fun updateCounterDisplay(count: Int) {
        tvCounter.text = count.toString()
    }
}
