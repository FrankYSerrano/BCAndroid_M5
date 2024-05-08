package com.example.reprolunes6

class AppConstant {
    companion object {

        const val LOG_MAIN_ACTIVITY = "ReproLunesSeis"

        const val MEDIA_PLAYER_POSITION = "miPosicion"

        const val MEDIA_PLAYER_PLAYING_STATUS = "miEstado"

        const val MEDIA_PLAYER_SONG_INDEX = "miPlayingSongIndex"


        val songs = listOf(
            Song("PPRemix - DLipa", R.raw.pp_remix, R.drawable.pretty_please),
            Song("STSadness - LdRey", R.raw.lr_ss, R.drawable.lr_ss),
            Song("ITEnd - LPark", R.raw.lp_in_the_end_remix, R.drawable.lp_in_the_emd_remix)
        )
    }
}