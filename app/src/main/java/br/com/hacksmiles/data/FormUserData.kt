package br.com.hacksmiles.data

import java.io.Serializable


data class FormUserData(
    var name: String,
    var birthDay: String,
    var preferences: String,
    var howMany: Int,
    var tripInitialDate: String = "",
    var tripEndDate: String = ""
) :
    Serializable {
}