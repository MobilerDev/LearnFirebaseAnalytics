package com.example.learnfirebaseanalytics

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        getAlertDialog()
        setListeners()
    }

    private fun getAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Fast Qestion")
        alertDialogBuilder.setMessage("Are you a dog person, or a cat person?")

        alertDialogBuilder.setPositiveButton("Dog person") { dialog, which ->
            Toast.makeText(applicationContext,
                "Dog", Toast.LENGTH_SHORT).show()
            firebaseAnalytics.setUserProperty("dog_person", "dog_or_cat")
        }

        alertDialogBuilder.setNegativeButton("Cat person") { dialog, which ->
            Toast.makeText(applicationContext,
                "Cat", Toast.LENGTH_SHORT).show()
            firebaseAnalytics.setUserProperty("cat_person", "dog_or_cat")
        }

        alertDialogBuilder.show()
    }

    private fun setListeners(){
        var mixList = listOf(box_one, box_two, box_three, box_four, box_five, box_six, box_seven, box_eight, box_nine, box_ten, box_eleven)
        for(i in mixList){
            i.setOnClickListener {
                makecolered(it)
            }
        }
    }
    private fun makecolered(view : View){
        when(view.id){
            R.id.box_one -> {
                view.setBackgroundResource(R.color.colorWhitePink)
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "item_box_one_id")
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
            }
            R.id.box_two -> {
                view.setBackgroundResource(R.color.colorDarkBrown)
            }
            R.id.box_three -> view.setBackgroundResource(R.color.colorLightBrown)
            R.id.box_four -> view.setBackgroundResource(R.color.colorDarkBlue)
            R.id.box_five -> view.setBackgroundResource(R.color.colorLightGreen)
            R.id.box_six -> view.setBackgroundResource(R.color.colorDarkGreen)
            R.id.box_seven -> view.setBackgroundResource(R.color.colorWhiteBrown)
            R.id.box_eight -> view.setBackgroundResource(R.color.colorLightPink)
            R.id.box_nine -> view.setBackgroundResource(R.color.colorLightPurple)
            R.id.box_ten -> view.setBackgroundResource(R.color.colorLightSomoon)
            R.id.box_eleven -> view.setBackgroundResource(R.color.colorIceBlue)
            else -> view.setBackgroundResource(R.color.colorWhiteGrey)
        }
    }
}