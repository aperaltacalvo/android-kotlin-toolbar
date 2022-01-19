package com.example.toolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toolbar.databinding.FragmentTextBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TextFragment : Fragment() {

    private var _binding:FragmentTextBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_text, container, false)
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }
    fun changeTextProperties(fontSize:Int, text:String){
        binding.textViewInfo.textSize = fontSize.toFloat()
        binding.textViewInfo.text = text

    }

}