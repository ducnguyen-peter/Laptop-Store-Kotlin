package com.example.laptopstorekotlin.learning

sealed class TestResult {

    class SUCCESS : TestResult()

    class FAILED(
        private val exception: Exception?
    ): TestResult()
}