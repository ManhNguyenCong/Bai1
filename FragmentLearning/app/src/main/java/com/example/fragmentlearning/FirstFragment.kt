package com.example.fragmentlearning

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentlearning.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Fragment 1st")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: Fragment 1st")
        // Inflate the layout for this fragment
        binding =
            FragmentFirstBinding.bind(inflater.inflate(R.layout.fragment_first, container, false))

        // Navigate to fragment B with replace
        binding.btnNavToFragmnetB.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SecondFragment>(R.id.fragmentContainerView)
            }
        }

        // Navigate to other activity with intent
        binding.btnNavToOtherActivity.setOnClickListener {
            startActivity(Intent(requireContext(), OtherActivity::class.java))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Fragment 1st")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Fragment 1st")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Fragment 1st")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Fragment 1st")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Fragment 1st")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: Fragment 1st")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Fragment 1st")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: Fragment 1st")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: Fragment 1st")
    }
}