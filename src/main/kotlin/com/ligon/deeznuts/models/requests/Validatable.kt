package com.ligon.deeznuts.models.requests

interface Validatable {
    fun validate(): Sequence<String>
}
