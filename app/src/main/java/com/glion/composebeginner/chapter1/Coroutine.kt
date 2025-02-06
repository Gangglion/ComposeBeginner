package com.glion.composebeginner.chapter1

import android.util.Log
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import java.lang.NullPointerException

object Coroutine {

    // MEMO : 정지함수 테스트용 함수
    suspend fun printForecast(){
        delay(1000) // MEMO : 정지함수에서만 delay 호출 가능
        Log.d("shhan","Sunny")
    }
    suspend fun printTemperature(){
        delay(1000)
        Log.d("shhan","30\u00b0C")
    }
    suspend fun getForecast(): String{
        delay(1000) // MEMO : 정지함수에서만 delay 호출 가능
        return "Sunny"
    }
    suspend fun getTemperature(): String{
        delay(1000)
        return "30\u00b0C"
    }
    suspend fun getTemperatureWithError(): String{
        delay(500)
        throw NullPointerException("의도한 NullPointerException") // MEMO : 에러 발생시 getTemperatureWithError 함수의 실행이 중지됨
        return "30\u00b0C"
    }
    // MEMO : 태스크의 범위를 지정. coroutineScope 내에서 실행된 코루틴은 이 범위 안에 그룹화된다. 내부적으로 동시에 작업을 하더라도,
    //  모든 작업 전까지는 coroutineScope 가 반환되지 않으므로, 함수가 동기 작업인것처럼 보이게 된다.
    suspend fun getWeatherReport() = coroutineScope {
        val forecast = async { getForecast() }
        val temperature = async { getTemperature() }
        "${forecast.await()} ${temperature.await()}" // MEMO : coroutineScope 람다의 리턴값
    }

    // MEMO : suspend 함수 내에서 try-catch 처리
    suspend fun getWeatherReportWithError() = coroutineScope {
        val forecast = async { getForecast() }
        val temperature = async { getTemperatureWithError() }
        "${forecast.await()} ${temperature.await()}" // MEMO : coroutineScope 람다의 리턴값
    }
    // MEMO : coroutineScopre 내에서 try-catch
    suspend fun getWeatherReportWithError2() = coroutineScope {
        val forecast = async { getForecast() }
        val temperature = async {
            try {
                getTemperatureWithError()
            } catch (e: NullPointerException) {
                "{ Error Occur, Not Found }"
            }
        }
        "${forecast.await()} ${temperature.await()}" // MEMO : coroutineScope 람다의 리턴값
    }
}