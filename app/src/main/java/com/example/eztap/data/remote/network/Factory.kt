package com.khiladiadda.data.remote.network

interface Factory<T> {
    fun create() : T
}