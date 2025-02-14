package com.example.lab2_android


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private var strResult: String = ""
    private var calcResult: Float = 0f
    private var calcOper: Int = 0

    private fun numClick(`val`: String) {
        if (`val` == "c"){
            strResult = ""
        }else {
            if (strResult.isEmpty() && `val` != "-") {
                strResult = `val`
            } else if (strResult.isNotEmpty() && `val` == "-") {
                if (strResult.first() == '-') {
                    strResult = strResult.drop(1)
                } else {
                    strResult = "-$strResult"
                }
            } else {
                strResult += `val`
            }
        }
    }

    private fun numCalc(`val`: Float) {
        if (calcOper == 0) {
            calcResult = `val`
        } else {
            if (calcOper == 1) calcResult += `val`
            if (calcOper == 2) calcResult -= `val`
            if (calcOper == 3) calcResult *= `val`
            if (calcOper == 4) calcResult /= `val`
            if (calcOper == 5) calcResult %= `val`
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textResult = findViewById<TextView>(R.id.textView)

        val btnPlus = findViewById<Button>(R.id.buttonPlus)
        val btnMinus = findViewById<Button>(R.id.buttonMinus)
        val btnMult = findViewById<Button>(R.id.buttonMultiply)
        val btnDiv = findViewById<Button>(R.id.buttonDivide)
        val btnPercent = findViewById<Button>(R.id.buttonPercent)
        val btnPlusMinus = findViewById<Button>(R.id.buttonPlusMinus)

        val btn0 = findViewById<Button>(R.id.button0)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)
        val btn7 = findViewById<Button>(R.id.button7)
        val btn8 = findViewById<Button>(R.id.button8)
        val btn9 = findViewById<Button>(R.id.button9)

        val btnResult = findViewById<Button>(R.id.buttonEquals)
        val btnEmpty = findViewById<Button>(R.id.buttonC)
        val btnPeriod = findViewById<Button>(R.id.buttonPeriod)

        val btnScopes =findViewById<Button>(R.id.buttonScopes)

        btnResult.setOnClickListener {
            if (strResult.isNotEmpty()) {
                numCalc(strResult.toFloat())
                strResult = ""
            }
            calcOper = 0
            textResult.text = String.format(Locale.getDefault(), "%.2f", calcResult)
        }

        btn0.setOnClickListener {
            numClick("0")
            textResult.text = strResult
        }

        btn1.setOnClickListener {
            numClick("1")
            textResult.text = strResult
        }

        btn2.setOnClickListener {
            numClick("2")
            textResult.text = strResult
        }

        btn3.setOnClickListener {
            numClick("3")
            textResult.text = strResult
        }

        btn4.setOnClickListener {
            numClick("4")
            textResult.text = strResult
        }

        btn5.setOnClickListener {
            numClick("5")
            textResult.text = strResult
        }

        btn6.setOnClickListener {
            numClick("6")
            textResult.text = strResult
        }

        btn7.setOnClickListener {
            numClick("7")
            textResult.text = strResult
        }

        btn8.setOnClickListener {
            numClick("8")
            textResult.text = strResult
        }

        btn9.setOnClickListener {
            numClick("9")
            textResult.text = strResult
        }

        btnPeriod.setOnClickListener {
            numClick(".")
            textResult.text = strResult
        }

        btnPlusMinus.setOnClickListener {
            numClick("-")
            textResult.text = strResult
        }

        btnEmpty.setOnClickListener {
            numClick("c")
            textResult.text = strResult
        }

        /** Operations  */
        btnPlus.setOnClickListener {
            if (strResult.isNotEmpty()) {
                numCalc(strResult.toFloat())
                strResult = ""
            }
            calcOper = 1
            textResult.text = String.format(Locale.getDefault(), "%.2f", calcResult)
        }

        btnMinus.setOnClickListener {
            if (strResult.isNotEmpty()) {
                numCalc(strResult.toFloat())
                strResult = ""
            }
            calcOper = 2
            textResult.text = String.format(Locale.getDefault(), "%.2f", calcResult)
        }

        btnMult.setOnClickListener {
            if (strResult.isNotEmpty()) {
                numCalc(strResult.toFloat())
                strResult = ""
            }
            calcOper = 3
            textResult.text = String.format(Locale.getDefault(), "%.2f", calcResult)
        }

        btnDiv.setOnClickListener {
            if (strResult.isNotEmpty()) {
                numCalc(strResult.toFloat())
                strResult = ""
            }
            calcOper = 4
            textResult.text = String.format(Locale.getDefault(), "%.2f", calcResult)
        }

        btnPercent.setOnClickListener {
            if(strResult.isNotEmpty()) {
                numCalc(strResult.toFloat())
                strResult = ""
            }
            calcOper = 5
            textResult.text = String.format(Locale.getDefault(), "%.2f", calcResult)
        }

        //secret zone
        btnScopes.setOnClickListener {
            val url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}