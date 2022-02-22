package com.example.lotteryprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private val removeNumberList = mutableListOf<Int>()     //list to hold all the numbers to avoided when generating random numbers
    private val res = mutableListOf<Int>()                  //list to hold all the generated numbers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val results = findViewById<TextView>(R.id.results)

        val result1 = findViewById<TextView>(R.id.result1)
        val result2 = findViewById<TextView>(R.id.result2)
        val result3 = findViewById<TextView>(R.id.result3)
        val result4 = findViewById<TextView>(R.id.result4)
        val result5 = findViewById<TextView>(R.id.result5)
        val result6 = findViewById<TextView>(R.id.result6)

        val button = findViewById<Button>(R.id.bt)
        button.setOnClickListener {
            calculate()
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }

        val removeNumber = findViewById<EditText>(R.id.userInput)
        val removeButton = findViewById<Button>(R.id.button2)
        removeButton.setOnClickListener{
            removeNumber(removeNumber)
        }

        val resetButton = findViewById<Button>(R.id.button3)
        resetButton.setOnClickListener{
            removeNumberList.clear()
        }

        val changeResult1 = findViewById<Button>(R.id.changeResult1)
        changeResult1.setOnClickListener{
            changeNumber(0)
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }

        val changeResult2 = findViewById<Button>(R.id.changeResult2)
        changeResult2.setOnClickListener{
            changeNumber(1)
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }

        val changeResult3 = findViewById<Button>(R.id.changeResult3)
        changeResult3.setOnClickListener{
            changeNumber(2)
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }

        val changeResult4 = findViewById<Button>(R.id.changeResult4)
        changeResult4.setOnClickListener{
            changeNumber(3)
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }

        val changeResult5 = findViewById<Button>(R.id.changeResult5)
        changeResult5.setOnClickListener{
            changeNumber(4)
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }

        val changeResult6 = findViewById<Button>(R.id.changeResult6)
        changeResult6.setOnClickListener{
            changeNumber(5)
            displayResults(results,result1,result2,result3,result4,result5,result6)
        }
    }
    /**
     *  method to generate six random unique numbers
     **/
    private fun calculate() {
        res.clear()     //resetting the list
        val gen = Random()
        var newNumber = 1 + gen.nextInt(49)
        while (res.size < 6) {
            println(newNumber)
            if (newNumber !in removeNumberList && newNumber !in res)
                    res.add(newNumber)
            else
                newNumber = 1 + gen.nextInt(49)
        }
    }

    /**
     * method to remove a number which is to be avoided when generating the six random numbers
     * @param removeNumber getting the user input
     */
    private fun removeNumber(removeNumber : EditText){
        val num = removeNumber.text.toString().toInt()
        removeNumberList.add(num)
        println(removeNumberList)
    }
    /**
     * method to regenerated a single number from the generated numbers
     */
    private fun changeNumber(numberId : Int){
        val gen = Random()
        var newNumber = 1 + gen.nextInt(49)
        while (true) {
            if (newNumber !in removeNumberList && newNumber !in res) {
                break
            }
            else {
                newNumber = 1 + gen.nextInt(49)
            }
        }
        res[numberId] = newNumber
    }
    /**
     * method to display all the generated results
     *  @param results text view to display all the result
     *  @param result1 text view to display the first generated number
     *  @param result2 text view to display the second generated number
     *  @param result3 text view to display the third generated number
     *  @param result4 text view to display the forth generated number
     *  @param result5 text view to display the fifth generated number
     *  @param result6 text view to display the sixth generated number
     */
    private fun displayResults(results: TextView, result1: TextView,result2: TextView,result3: TextView,result4: TextView,result5: TextView,result6: TextView){
        results.text = " "
        for (i in res) {
            results.append("$i ")
        }
        result1.text = res[0].toString()
        result2.text = res[1].toString()
        result3.text = res[2].toString()
        result4.text = res[3].toString()
        result5.text = res[4].toString()
        result6.text = res[5].toString()
    }
}