package com.example.top_soccer_teams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays
import android.util.Log

//looks for the shortest entry in the string array
fun getShorttestString(arr: Array<String>) : String{
    var shortestLength = arr[0]

    for(element in arr){
        if (element.length < shortest.length){
            shortestLength = element
        }
    }
    return shortestLength
}



//logs the content of an array of strings
fun logArrayValues(arr: Array<String>, limit: Int = 0){
    if (limit == 0){
        Log.v("Array Values", Arrays.toString(arr))
    }else{
        Log.v("Array Values, Arrays.toString"(
            arr.sliceArray(0..limit - 1)))
    }
}
class MainActivity : AppCompatActivity() {

    val teams = arrayOf<String>("Mamelodi Sundowns FC", "Orlando Pirates", "Bidvest Wits",
        "Stellenbosch FC", "Sek United")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val teamsTxt = findViewById<TextView>(R.id.teamDisplayId)

        val shortest = getShortestLength(teams)

        //reassigned position 0 of teams array to a new value
        teams[0] = "Mamelodi Sundowns :)"

        //calling function to display all values
        logArrValues(teams)

        //calling fuction to display shortest string in array
        Log.d("RESULT", "Shortest length is: $shortest")

        //calling functions to display with a limit
        logArrValues(teams, 4)

        //assigning array content to a variable

        //for loop to loop all the display for teams to view
        var teamsDisplay = ""
        for (team in teams){
            teamsDisplay += "${team}\n"
        }




//        var teamsDisplay = ""
//        var count = 0
//        while (count< teams.count()) {
//            teamsDisplay += "${teams[count]}\n"
//            count++
//        }



//        teamsDisplay +="${teams[0]}\n"
//        teamsDisplay +="${teams[1]}\n"
//        teamsDisplay +="${teams[2]}\n"
//        teamsDisplay +="${teams[3]}\n"
//        teamsDisplay +="${teams[4]}\n"


        //displaying array content in the text view
        teamsTxt.text = teamsDisplay

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}