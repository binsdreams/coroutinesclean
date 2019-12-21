package com.bins.presentation.base

abstract class Mapper<in T,E>{

    abstract fun mapFrom(from: T): E
}