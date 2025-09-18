package com.example.lab_week_04

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val coffeeTitle: TextView?get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView?get() = view?.findViewById(R.id.coffee_desc)
    private val backButton: Button?get() = view?.findViewById(R.id.back_button)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId )


        backButton?.setOnClickListener {
//            findNavController().popBackStack()
            findNavController().navigate(R.id.listFragment)
        }

    }

    private val coffeeData = mapOf(
        R.id.affogato to Pair(R.string.affogato_title, R.string.affogato_desc),
        R.id.americano to Pair(R.string.americano_title, R.string.americano_desc),
        R.id.latte to Pair(R.string.latte_title, R.string.latte_desc),
        R.id.cappuccino to Pair(R.string.cappuccino_title, R.string.cappuccino_desc),
        R.id.espresso to Pair(R.string.espresso_title, R.string.espresso_desc),
        R.id.flatwhite to Pair(R.string.flatwhite_title, R.string.flatwhite_desc),
        R.id.mocha to Pair(R.string.mocha_title, R.string.mocha_desc)
    )

    fun setCoffeeData(id: Int){
        //Mapping method
        coffeeData[id]?.let { (cofTitle, cofDes) ->
            coffeeTitle?.text = getString(cofTitle)
            coffeeDesc?.text = getString(cofDes)
        }
        /*when(id){
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }
        }*/


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */

        private const val COFFEE_ID = "COFFEE_ID"
        @JvmStatic
        fun newInstance(coffeeId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(COFFEE_ID, coffeeId)
                }
            }
    }
}