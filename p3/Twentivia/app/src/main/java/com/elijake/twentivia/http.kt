package com.elijake.twentivia

import java.net.HttpURLConnection
import java.net.URL

class Http {
    fun get(url:String) {
        with(URL(url).openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    println(line)
                }
            }
        }

    }
}