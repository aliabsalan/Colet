package com.children.colet.screens.greeting

import android.content.Context
import androidx.core.content.edit

val shpNameGreeting = "Greeting"
val shpKeyIsGreetingPassed = "IsGreetingPassed"
val shpKeyName = "Name"


fun checkGreetingPassed(context:Context): Boolean {
   val shp = context.getSharedPreferences(shpNameGreeting , Context.MODE_PRIVATE)
    return shp.getBoolean(shpKeyIsGreetingPassed , false)
}

fun setGreetingPassed(context: Context , name:String){
    val shp = context.getSharedPreferences(shpNameGreeting , Context.MODE_PRIVATE)
    shp.edit {
        putBoolean(shpKeyIsGreetingPassed , true)
        if (name.isNotEmpty())
        putString(shpKeyName , name)
        else
        putString(shpKeyName , GreetingDefault.defaultName)
        apply()
    }

}