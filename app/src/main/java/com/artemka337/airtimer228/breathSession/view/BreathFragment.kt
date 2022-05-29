package com.artemka337.airtimer228.breathSession.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.artemka337.airtimer228.R
import com.artemka337.airtimer228.breathSession.viewModel.breathViewModel

class BreathFragment: Fragment() {
    val viewModel: breathViewModel = breathViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_breath_session, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listener = this

        val deadly = view.findViewById<TextView>(R.id.vdoh1)
        val parkour = view.findViewById<TextView>(R.id.vdoh)
        val killer = view.findViewById<TextView>(R.id.zaderzhka)
        val dark = view.findViewById<TextView>(R.id.zaderzhka2)

        deadly.text = viewModel.parameter.inhale.toString()
        parkour.text = viewModel.parameter.inhale.toString()
        killer.text = viewModel.parameter.exhale.toString()
        dark.text = viewModel.parameter.exhale.toString()

        view.findViewById<Button>(R.id.startBaton).setOnClickListener {
            viewModel.startSession()
        }
    }

    fun onChange(newValues: SessionParameters){
        val deadly = view?.findViewById<TextView>(R.id.vdoh1)
        val parkour = view?.findViewById<TextView>(R.id.vdoh)
        val killer = view?.findViewById<TextView>(R.id.zaderzhka)
        val dark = view?.findViewById<TextView>(R.id.zaderzhka2)

        deadly?.text = newValues.parameter.inhale.toString()
        parkour?.text = newValues.parameter.inhale.toString()
        killer?.text = newValues.parameter.exhale.toString()
        dark?.text = newValues.parameter.exhale.toString()
    }


    fun setStartEnabled(value : Boolean){
        view?.findViewById<Button>(R.id.startBaton)?.isEnabled = value
    }



}