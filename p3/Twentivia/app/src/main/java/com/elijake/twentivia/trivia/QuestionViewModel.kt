package com.elijake.twentivia.trivia


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elijake.twentivia.model.Question

/**
 * The [ViewModel] that is attached to the [TriviaActivity].
 */
class QuestionViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<Question>()

    // The external immutable LiveData for the request status
    val status: LiveData<Question> = _status

    /**
     * Call getTriviaQuestions() on init so we can display status immediately.
     */
    init {
        getTriviaQuestions()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("QuestionViewModel", "QuestionViewModel destroyed!")
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates
     */
    private fun getTriviaQuestions() {
        _status.value = Question("Why?", "Just because", "Hard", "yes", listOf("no", "no", "no"))
    }
}