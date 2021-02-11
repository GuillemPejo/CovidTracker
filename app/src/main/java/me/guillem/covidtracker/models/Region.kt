package me.guillem.covidtracker.models

data class Region(
    val date: String,
    val id: String,
    val name: String,
    val name_es: String,
    val name_it: String,
    val source: String,
    //val sub_regions: List<SubRegion>,
    val today_confirmed: Int,
    val today_deaths: Int,
    val today_hospitalised_patients_with_symptoms: Int,
    val today_intensive_care: Int,
    val today_new_confirmed: Int,
    val today_new_deaths: Int,
    val today_new_hospitalised_patients_with_symptoms: Int,
    val today_new_intensive_care: Int,
    val today_new_open_cases: Int,
    val today_new_recovered: Int,
    val today_new_total_hospitalised_patients: Int,
    val today_open_cases: Int,
    val today_recovered: Int,
    val today_total_hospitalised_patients: Int,
    val today_vs_yesterday_confirmed: Double,
    val today_vs_yesterday_deaths: Double,
    val today_vs_yesterday_hospitalised_patients_with_symptoms: Any,
    val today_vs_yesterday_intensive_care: Double,
    val today_vs_yesterday_open_cases: Double,
    val today_vs_yesterday_recovered: Double,
    val today_vs_yesterday_total_hospitalised_patients: Double,
    val yesterday_confirmed: Int,
    val yesterday_deaths: Int,
    val yesterday_hospitalised_patients_with_symptoms: Int,
    val yesterday_intensive_care: Int,
    val yesterday_open_cases: Int,
    val yesterday_recovered: Int,
    val yesterday_total_hospitalised_patients: Int
)