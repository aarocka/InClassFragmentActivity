package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        mainViewModel.setImageIds(imageArray)

        //log the imageArray
        for (i in imageArray.indices) {
            Log.d( "onCreate: ", imageArray[i].toString());
        }

        // Attach an instance of ImageDisplayFragment using factory method
        // newInstance() to the FrameLayout in activity_main.xml
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, ImageDisplayFragment())
            .commit()




        /*
        // Create an instance of the interface
        fun imageSelected(itemId: Int){
            Toast.makeText(this, "Image $itemId selected", Toast.LENGTH_SHORT).show()
        }
        */

        //




    }
}