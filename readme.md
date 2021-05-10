# Home Inspector Application

## Author
Matthew Palkowski
https://github.com/matthewpalkowski/

## Application intent

The homes we live in are some of the most fundamental parts of everyone's day to day life in the United States.
The places we live are a key factor in some of the most basic elements of our lives down to the water we drink, 
the air we breathe, people and community we can engage with. Most similar applications available only concern
themselves with the immediate financial consideration around a piece of real-estate. While this financial 
information is still important, it fails to take into account of the myriad of other important factors that 
potential tenant out to concern themselves with when choosing where to live.

The goal of Home Inspector is to put the important information beyond just the financial aspects of a given property
directly at the user's fingertips. Home Inspector takes information from sources like the EPA to give the user
access to the other risks a particular residence might pose to them beyond just the risk to their wallet.

## Application Requirements

Home Inspector is currently only available on Android and requires that the device is operating on Android 7.1  
Nougat (API level 25) or greater. Attempting to use earlier version of the Android Operating system may lead to
compatability issues and unexpected crashes.

Note that while this project is in developement, the user will have to provide thier own API keys to use the API
connections within this aplication. To do this a file name "ApiKeys.kt" should be added to 
\app\src\main\java\com\example\finalproject directory.

This file should contain the following text with the |YOUR API KEY HERE| tags replaced by the user's own API key.
package com.example.finalproject

class ApiKeys {
    companion object {
        const val GOOGLE_API_KEY: String = "|YOUR API KEY HERE|"
    }
}

## References

"Learn how to call multiple APIs in Parallel and in sequence with the help of RxJava Operators". : TechUrTime :. https://www.youtube.com/watch?v=vGlyTgIdQQ0.
CCSU - CS560 Lectures. Yusuf Albayram. https://ccsu.blackboard.com/webapps/blackboard/content/listContent.jsp?course_id=_57469_1&content_id=_1777319_1&mode=reset.
CCSU - CS560 Class Examples. Yusuf Albayram. https://ccsu.blackboard.com/webapps/blackboard/content/listContent.jsp?course_id=_57469_1&content_id=_1777319_1&mode=reset.

## API Endpoints
GoogleGeocoding API - https://maps.googleapis.com/maps/api/geocode/.