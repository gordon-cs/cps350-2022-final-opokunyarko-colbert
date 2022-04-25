package com.elijake.twentivia


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * The [ViewModel] that is attached to the [TriviaActivity].
 */
class QuestionViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getTriviaQuestions() on init so we can display status immediately.
     */
    init {
        getTriviaQuestions()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates
     */
    private fun getTriviaQuestions() {
        _status.value = "Set the API status response here!"
    }
}