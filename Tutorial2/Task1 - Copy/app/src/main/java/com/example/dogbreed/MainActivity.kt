package com.example.dogbreed

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity() {

    private val dogImagesRef = mutableListOf(
        "img1","img2","img3","img4","img5",
        "img6","img7","img8","img9","img10",
        "img11","img12","img13","img14","img15",
        "img16","img17","img18","img19","img20",
        "img21","img22","img23","img24","img25"
    )

    private val dogBreed = mutableListOf(
        "German Shepherd","German Shepherd","German Shepherd","German Shepherd","German Shepherd",
        "Golden Retriever","Golden Retriever","Golden Retriever","Golden Retriever","Golden Retriever",
        "Siberian Husky","Siberian Husky","Siberian Husky","Siberian Husky","Siberian Husky",
        "EntleBucher","EntleBucher","EntleBucher","EntleBucher","EntleBucher",
        "Labrador Retriever","Labrador Retriever","Labrador Retriever","Labrador Retriever","Labrador Retriever"
    )

    private val finalImagesIndex = mutableListOf<Int>()
    private val gen = Random()
    private var solution = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagesDisplay = findViewById<ConstraintLayout>(R.id.questionView)
        val resultDisplay = findViewById<ConstraintLayout>(R.id.solutionView)

        val imgView1 = findViewById<ImageView>(R.id.imageButton1)
        val imgView2 = findViewById<ImageView>(R.id.imageButton2)
        val imgView3 = findViewById<ImageView>(R.id.imageButton3)

        val submitButton = findViewById<Button>(R.id.button)
        val nextButton = findViewById<Button>(R.id.button2)

        val questionText = findViewById<TextView>(R.id.displayQuestion)
        val resultText = findViewById<TextView>(R.id.displaySolution)

        displayImages(imgView1,imgView2,imgView3,questionText)

        imgView1.setBackgroundResource(R.drawable.button_normal_border)
        imgView2.setBackgroundResource(R.drawable.button_normal_border)
        imgView3.setBackgroundResource(R.drawable.button_normal_border)

        submitButton.setOnClickListener {
            imagesDisplay.isVisible = false
            resultDisplay.isVisible = true
        }

        nextButton.setOnClickListener {
            resultDisplay.isVisible = false
            imagesDisplay.isVisible = true
            resetOptions(imgView1,imgView2,imgView3,resultText)
            displayImages(imgView1,imgView2,imgView3,questionText)
        }

        imgView1.setOnClickListener {
            imgView1.setBackgroundResource(R.drawable.button_clicked_border)
            checkAnswer(1,resultText)
            imgView2.isClickable = false
            imgView3.isClickable = false
        }

        imgView2.setOnClickListener {
            imgView2.setBackgroundResource(R.drawable.button_clicked_border)
            checkAnswer(2,resultText)
            imgView1.isClickable = false
            imgView3.isClickable = false
        }

        imgView3.setOnClickListener {
            imgView3.setBackgroundResource(R.drawable.button_clicked_border)
            checkAnswer(3,resultText)
            imgView1.isClickable = false
            imgView2.isClickable = false
        }
    }

    private fun displayImages(imgView1:ImageView,imgView2:ImageView,imgView3:ImageView,questionText: TextView){
        getRandomImageIndex()
        println(finalImagesIndex)
        val resource1 = dogImagesRef[finalImagesIndex[0]]
        val resource2 = dogImagesRef[finalImagesIndex[1]]
        val resource3 = dogImagesRef[finalImagesIndex[2]]

        val resourceId1 = resources.getIdentifier(
            resource1,
            "drawable",
            "com.example.dogbreed"
        )
        val resourceId2 = resources.getIdentifier(
            resource2,
            "drawable",
            "com.example.dogbreed"
        )
        val resourceId3 = resources.getIdentifier(
            resource3,
            "drawable",
            "com.example.dogbreed"
        )

        imgView1.setImageResource(resourceId1)
        imgView2.setImageResource(resourceId2)
        imgView3.setImageResource(resourceId3)

        val randomIndex = 0 + gen.nextInt(2)

        solution = randomIndex +1

        questionText.text = dogBreed[finalImagesIndex[randomIndex]]
        println( dogBreed[finalImagesIndex[randomIndex]])

    }

    private fun resetOptions(imgView1:ImageView,imgView2:ImageView,imgView3:ImageView,resultText: TextView){
        imgView1.setBackgroundResource(R.drawable.button_normal_border)
        imgView2.setBackgroundResource(R.drawable.button_normal_border)
        imgView3.setBackgroundResource(R.drawable.button_normal_border)

        imgView1.isClickable = true
        imgView2.isClickable = true
        imgView3.isClickable = true

        resultText.text = ""
        resultText.setBackgroundColor(Color.WHITE)
    }


    private fun checkAnswer(num : Int, solutionLabel: TextView){
        if (num ==solution ){
            solutionLabel.text = getString(R.string.correct)
            solutionLabel.setBackgroundColor(Color.GREEN)
        }
        else{
            solutionLabel.text = getString(R.string.wrong)
            solutionLabel.setBackgroundColor(Color.RED)
        }
    }

    private fun getRandomImageIndex(){
        finalImagesIndex.clear()

        val dogBreedTypeArray = mutableListOf<Int>()
        var dogBreedType = 1 + gen.nextInt(5)

        while (dogBreedTypeArray.size < 3) {
            if (dogBreedType !in dogBreedTypeArray)
                dogBreedTypeArray.add(dogBreedType)
            else
                dogBreedType = 1 + gen.nextInt(5)
        }

        val randomDogImageBreed = 0 + gen.nextInt(4)
        for (i in dogBreedTypeArray.indices) {
            when (dogBreedTypeArray[i]){
                1-> finalImagesIndex.add( 0+randomDogImageBreed)
                2-> finalImagesIndex.add( 5+randomDogImageBreed)
                3-> finalImagesIndex.add(10+randomDogImageBreed)
                4-> finalImagesIndex.add(15+randomDogImageBreed)
                5-> finalImagesIndex.add(20+randomDogImageBreed)
            }
        }
    }

}