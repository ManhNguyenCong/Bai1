package com.example.fragmentlearning

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentlearning.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Fragment 2nd")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: Fragment 2nd")

        binding =
            FragmentSecondBinding.bind(inflater.inflate(R.layout.fragment_second, container, false))

        // Navigate to fragment A with replace
        binding.btnNavToFragmentA.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FirstFragment>(R.id.fragmentContainerView)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Fragment 2nd")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Fragment 2nd")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Fragment 2nd")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Fragment 2nd")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Fragment 2nd")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: Fragment 2nd")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Fragment 2nd")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: Fragment 2nd")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: Fragment 2nd")
    }
}