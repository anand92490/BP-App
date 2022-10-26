package com.anandchaudhary.bphistory

import java.util.*

data class BloodPressure(var systolic: Int,
                         var diastolic: Int,
                         var date: Date) {

    companion object {
        //  categories and recommendations are parallel arrays

        val categories = arrayOf(
            "Low reading; reevaluate",
            "Normal blood pressure",
            "Elevated blood pressure", // formerly "prehypertension"
            "Stage 1 hypertension",
            "Stage 2 hypertension",
            "Hypertenisve crisis"
        )

        val recommendations = arrayOf(
            "Take blood pressure reading again.",
            "Normal blood pressure, no treatment needed.",
            "Lifestyle changes. Reexamine in 3-6 months.",
            "Low-risk of ASCVD: Lifestyle changes; Reexamine in 3-6 months. Otherwise, " +
                    "treatment with 1 blood pressure lowering drug; reexamine in 1 month.",
            "Treatment with 2 blood pressure-lowering drugs. Reexamine in one month.",
            "Consult your doctor immediately"
        )
    }

    fun category() = when {
        systolic < 100 || diastolic < 60 -> 0   // "Low reading; reevaluate";
        systolic < 120 && diastolic < 80 -> 1   // "Normal blood pressure";
        systolic < 130 && diastolic < 80 -> 2   // "Elevated blood pressure";
        systolic < 140 && diastolic < 90 -> 3   // "Stage 1 hypertension";
        systolic < 180 && diastolic < 120 -> 4   // "Stage 2 hypertension":
        else -> 5 // Hypertensive crisis
    }
}


