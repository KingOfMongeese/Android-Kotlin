package com.example.cis386_first_android_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cis386_first_android_app.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        binding.toastButton.setOnClickListener {
            val myToast = Toast.makeText(context, getString(R.string.toast_message) , Toast.LENGTH_SHORT)
            myToast.show()
        }
        binding.countButton.setOnClickListener {
            countMe(view)
       }

        binding.countDownButton.setOnClickListener {
            countMeDown(view)
        }

        binding.countButton.setOnLongClickListener {
            countMe10(view)
        }

        binding.countDownButton.setOnLongClickListener {
            countMeDown10(view)
        }

    }

    private fun countMe(view: View) {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()

        var count = countString.toInt()
        count++

        showCountTextView.text = count.toString()

    }

    private fun countMe10(view: View): Boolean {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()

        var count = countString.toInt()
        count += 10

        showCountTextView.text = count.toString()

        return true;

    }

    private fun countMeDown(view: View) {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()

        var count = countString.toInt()
        count--

        showCountTextView.text = count.toString()

    }

    private fun countMeDown10(view: View): Boolean {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()

        var count = countString.toInt()
        count -= 10

        showCountTextView.text = count.toString()

        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}