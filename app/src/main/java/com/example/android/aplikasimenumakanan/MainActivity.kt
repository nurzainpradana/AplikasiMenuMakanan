package com.example.android.aplikasimenumakanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var listFoodChecked: Map<CheckBox, Int>
    lateinit var listDrinkChecked: Map<CheckBox, Int>

    /* var localeId = Locale("id", "ID")
    var formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeId)
     */

    var totalFood: Int = 0
    var totalDrink: Int = 0
    var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calculateNow(view: View) {
        total = 0

        getSelectedFood()
        getSelectedDrink()

        tv_food_total.text = totalFood.toString()
        tv_drink_total.text = totalDrink.toString()
        tv_total.text = total.toString()
    }

    private fun getSelectedFood() {
        listFoodChecked = mapOf(
            cb_food_one to 15000,
            cb_food_two to 12000,
            cb_food_three to 16000,
            cb_food_four to 15000
        )

        totalFood = 0

        for ((checkedItem, price) in listFoodChecked){
            if (checkedItem.isChecked){
                var subTotalFood: Int
                when(checkedItem){
                    cb_food_one -> {
                        if (et_food_one.text.toString() != ""){
                            subTotalFood = et_food_one.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }

                    cb_food_two -> {
                        if (et_food_two.text.toString() != "") {
                            subTotalFood = et_food_two.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }

                    cb_food_three -> {
                        if (et_food_three.text.toString() != "") {
                            subTotalFood = et_food_three.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }

                    cb_food_four -> {
                        if (et_food_four.text.toString() != "") {
                            subTotalFood = et_food_four.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }
                }
            }
        }
        total += totalFood
    }

    private fun getSelectedDrink() {
        listDrinkChecked = mapOf(
            cb_drink_one to 5000,
            cb_drink_two to 1000,
            cb_drink_three to 3000,
            cb_drink_four to 6000
        )

        totalDrink = 0

        for ((checkedItem, price) in listDrinkChecked){
            if (checkedItem.isChecked){
                var subTotalDrink: Int
                when(checkedItem){
                    cb_drink_one -> {
                        if (et_drink_one.text.toString() != "") {
                            subTotalDrink = et_drink_one.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }

                    cb_drink_two -> {
                        if (et_drink_two.text.toString() != "") {
                            subTotalDrink = et_drink_two.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }

                    cb_drink_three -> {
                        if (et_drink_three.text.toString() != "") {
                            subTotalDrink = et_drink_three.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }

                    cb_drink_four -> {
                        if (et_drink_four.text.toString() != "") {
                            subTotalDrink = et_drink_four.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }
                }
            }
        }
        total += totalDrink
    }

    fun payNow(view: View) {
        if (tv_total.text.toString() != ""){
            if (et_total_pay.text.toString() != ""){
                var total_pay = et_total_pay.text.toString().toInt()
                if (total_pay > total){
                    total_pay -= total
                    val makeText = Toast.makeText(this, "Kembalian anda $total_pay", Toast.LENGTH_SHORT)
                    makeText.setGravity(Gravity.TOP, 0, 0)
                    makeText.show()
                } else if (total_pay == total){
                    val makeText = Toast.makeText(this, "Terimakasih Sudah Berbelanja", Toast.LENGTH_SHORT)
                    makeText.setGravity(Gravity.TOP, 0, 0)
                    makeText.show()
                } else {
                    val makeText = Toast.makeText(this, "Maaf, Uang Anda Tidak Cukup", Toast.LENGTH_SHORT)
                    makeText.setGravity(Gravity.TOP, 0, 0)
                    makeText.show()
                }
            } else {
                val makeText = Toast.makeText(this, "Anda Belum Memasukkan Nominal", Toast.LENGTH_SHORT)
                makeText.setGravity(Gravity.TOP, 0, 0)
                makeText.show()
            }
        } else {
            val makeText = Toast.makeText(this, "Anda Belum Memilih Menu", Toast.LENGTH_SHORT)
            makeText.setGravity(Gravity.TOP, 0, 0)
            makeText.show()
        }
    }
}
