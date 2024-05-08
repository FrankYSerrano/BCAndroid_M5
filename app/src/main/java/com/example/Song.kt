package com.example

import com.example.programandokotlin.R

data class Song (
    val title: String,
    val audioResId: Int,
    val imageResId: Int)
{}

class AppConstant {
    companion object {

        const val LOG_MAIN_ACTIVITY = "ReproLunes6"

        val songs = listOf(
            Song("PPRemix - DLipa", R.raw.pp_remix, R.drawable.pretty_please),
            Song("STSadness - LdRey", R.raw.lr_ss, R.drawable.lr_ss),
            Song("ITEnd - LPark", R.raw.lp_in_the_end_remix, R.drawable.lp_in_the_emd_remix)
        )
    }
}