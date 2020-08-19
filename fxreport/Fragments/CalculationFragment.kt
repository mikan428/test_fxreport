package com.example.fxreport.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fxreport.R
import kotlinx.android.synthetic.main.fragment_calculation.view.*
import java.lang.Double.parseDouble


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CalculationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculation, container, false)



        view.keisan.setOnClickListener {

            var Valid = true

            val rates_bar = view.findViewById<EditText>(R.id.rate_bar)
            val rates_check = rates_bar.text.toString()

            if (rates_check.isEmpty())
            {
                rates_bar.error = getString(R.string.assets_bar)
                Valid = false
            }


            val lots_bar = view.findViewById<EditText>(R.id.lot_bar)
            val lots_check = lots_bar.text.toString()


            if(lots_check.isEmpty())
            {
                lots_bar.error = getString(R.string.lot_bar)
                Valid = false
            }

            val asset_bar = view.findViewById<EditText>(R.id.assets_bar)
            val asset_check = asset_bar.text.toString()

            if (asset_check.isEmpty())
            {
                asset_bar.error = getString(R.string.assets_bar)
                Valid = false
            }

            if(Valid)
            {
                  val rate =  Integer.parseInt(rates_check.toString())
                  val lot = Integer.parseInt(lots_check.toString())
                  val assets = Integer.parseInt(asset_check.toString())
                  val kekka = lot * rate * 400
                  val result = assets - kekka

                  val kekka_hyouji = view.findViewById<TextView>(R.id.kekka_text)

                  kekka_hyouji.text = getString(R.string. kekka_hyouji,kekka)

                  val result_hyouji = view.findViewById<TextView>(R.id.losscut_text)

                  result_hyouji.text = getString(R.string. result_hyouji,result)





            }


        }

        return view

    }



}