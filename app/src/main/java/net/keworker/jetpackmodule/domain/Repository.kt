package net.keworker.jetpackmodule.domain

import net.keworker.jetpackmodule.domain.model.Result

interface Repository {
    fun getResult(id: Int): Result
    fun getAllResults(): Result
    fun setResult(result: Result)
}
