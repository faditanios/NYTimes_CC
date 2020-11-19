package com.codechallenge.nytimes

import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset

class APIAvailabilityTest
{
    @Test
    @Throws(Exception::class)
    fun testAvailability()
    {
        val connection =
            URL("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=4FGdb1PMHGv6GiMkQtFQmIkppHr8uIz2").openConnection()
        val response = connection.getInputStream()
        val buffer = StringBuffer()
        BufferedReader(InputStreamReader(response, Charset.defaultCharset())).use { reader ->
            var line: String?
            while (reader.readLine().also { line = it } != null)
            {
                buffer.append(line)
            }
        }
        assert(buffer.isNotEmpty())
    }
}