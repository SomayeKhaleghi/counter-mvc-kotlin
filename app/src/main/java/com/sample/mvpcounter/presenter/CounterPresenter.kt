package com.sample.mvpcounter.presenter

import com.sample.mvpcounter.model.CounterModel
import com.sample.mvpcounter.view.CounterView

/**
 * Presenter that handles user actions and updates the View.
 */
class CounterPresenter(private val view: CounterView) {

    private val counterModel = CounterModel()

    /**
     * Called when the user requests to increment the counter.
     */
    fun onIncrementClicked() {
        incrementCounter()
        updateView()
    }

    private fun incrementCounter() {
        counterModel.value += 1
    }

    private fun updateView() {
        view.updateCounterDisplay(counterModel.value)
    }
}
