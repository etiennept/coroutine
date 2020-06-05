@file:Suppress("IMPLICIT_CAST_TO_ANY", "NAME_SHADOWING")
package com.coroutine

import kotlinx.coroutines.*

fun main (){
   print(parseJSON("{eeee : rrrr,rrrrr : tttt  ,ffff  : ttttt }"))
    }

fun rrrr(a :String): Any {
    val c = if (!a.matches(Regex("""[{}]"""))) {
        println("tttt")
        val rrr = mutableMapOf<String, Any>()
        a.split(",").map {
            val f = it.split(Regex(":"))
            rrr.put(f[0], rrrr(f[1]) )
        }
        rrr.toMap()
    }

    else if (!a.matches(Regex("""[[|]]"""))) {
    a.split(",").map {
        rrrr(it)
    }} else a
    return c

}
fun parseJSON(json : String): Any {
    val x = json.split(Regex(" "))
    var a = ""
    x.map { if (it != "")  a+= it   }
    return rrrr(a)
}