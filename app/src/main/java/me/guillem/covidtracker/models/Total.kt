package me.guillem.covidtracker.models

/**
 ** Created by Guillem on 11/02/21.
 */
data class Total(
    val date: String,
    val name: String,
    val name_es: String,
    val name_it: String,
    val rid: String,
    val source: String,
    val today_confirmed: Int,
    val today_deaths: Int,
    val today_new_confirmed: Int,
    val today_new_deaths: Int,
    val today_new_open_cases: Int,
    val today_new_recovered: Int,
    val today_open_cases: Int,
    val today_recovered: Int,
    val today_vs_yesterday_confirmed: Double,
    val today_vs_yesterday_deaths: Double,
    val today_vs_yesterday_open_cases: Double,
    val today_vs_yesterday_recovered: Double,
    val yesterday_confirmed: Int,
    val yesterday_deaths: Int,
    val yesterday_open_cases: Int,
    val yesterday_recovered: Int
    )
