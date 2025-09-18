package com.example.lab_week_04

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(){
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    private lateinit var coffeeListener: CoffeeListener;

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if(context is CoffeeListener)
//            coffeeListener = context
//        else
//            throw RuntimeException("Must implement CoffeeListener")
//    }

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
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Experiment with looping
        /* coffeeNameList = listOf(
            getString(R.string.affogato_title),
            getString(R.string.americano_title),
            getString(R.string.latte_title),
            getString(R.string.cappuccino_title),
            getString(R.string.espresso_title),
            getString(R.string.flatwhite_title),
            getString(R.string.mocha_title)
        )

        val container: LinearLayout = view.findViewById(R.id.coffee_container)

        for (coffee in coffeeNameList) {
            val textView = TextView(requireContext()).apply {
                id = "@+id/" + coffee
                text = coffee
                setPadding(10, 10, 10, 10)
                textSize = 18f
            }
            container.addView(textView)
        }*/

        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino),
            view.findViewById(R.id.espresso),
            view.findViewById(R.id.flatwhite),
            view.findViewById(R.id.mocha)
        )



//        coffeeList.forEach { it.setOnClickListener(this) }

        coffeeList.forEach { coffee ->
            val fragmentBundle = Bundle()
            fragmentBundle.putInt(COFFEE_ID, coffee.id)
            coffee.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.action_listFragment_to_detailFragment, fragmentBundle)
            )
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        const val COFFEE_ID = "COFFEE_ID"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}