package com.codechallenge.nytimes.util.api

/**
 * A generic wrapper class around data request
 */
data class State<RequestData>(
    var responseType: Status,
    var data: RequestData? = null,
    var error: Exception? = null
)

enum class Status
{ SUCCESSFUL, ERROR, LOADING }

