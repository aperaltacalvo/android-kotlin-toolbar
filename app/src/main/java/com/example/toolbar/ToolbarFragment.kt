package com.example.toolbar

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.toolbar.databinding.FragmentTextBinding
import com.example.toolbar.databinding.FragmentToolbarBinding
import java.lang.ClassCastException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ToolbarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    var seekValue = 10
    private var _binding:FragmentToolbarBinding? = null
    private val binding get() = _binding!!
    private var activityCallback:ToolbarListener? = null

    interface ToolbarListener {
        fun onButonClick(position:Int, text:String)
    }
    //Context is the main activity. You can cast to ToolbarListener because you are implementing the interface in MainActivity class
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        }catch (e:ClassCastException){
            throw ClassCastException(context.toString() + "The context should implement ToolbarListener")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_toolbar, container, false)
        _binding = FragmentToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onProgressChanged(seeBark: SeekBar?, progress: Int, fromUser: Boolean) {
        seekValue = progress
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.seekBar.setOnSeekBarChangeListener(this)
        binding?.button?.setOnClickListener{
            activityCallback?.onButonClick(seekValue,binding.editTextTextPersonName.text.toString())

        }
    }
    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }


}