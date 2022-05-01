package com.elijake.twentivia.trivia


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.elijake.twentivia.R
import com.elijake.twentivia.databinding.TriviaFragmentBinding

/**
 * This fragment shows the the status of the Mars photos web services transaction.
 */
class QuestionFragment : Fragment() {

    // private lateinit var binding: TriviaFragmentBinding
    private lateinit var viewModel: QuestionViewModel

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        var binding = DataBindingUtil.inflate(inflater, R.layout.trivia_fragment, container, false)

        Log.i("QuestionFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the QuestionViewModel
        binding.Question = viewModel

        return binding.root
    }
}