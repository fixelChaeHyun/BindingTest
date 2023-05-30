package ch.demo.testbindinglayout

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ch.demo.testbindinglayout.databinding.FragmentTestBinding

private const val ARG_PARAM1 = "param1"

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TestViewModel

    private var startParam: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // bundle check
        arguments?.let {
            startParam = it.getString(ARG_PARAM1)
        }
        Log.d("TestFragment", "startParam : $startParam")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        Log.e("TestFragment", "onCreateView -()")

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
    }

    companion object {
        fun newInstance(param1: String): Fragment {
            return TestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
        }
    }

}