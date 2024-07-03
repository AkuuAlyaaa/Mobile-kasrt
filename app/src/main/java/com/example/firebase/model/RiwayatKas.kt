package com.example.firebase.model

data class RiwayatKas(
    val namaWarga: String,
    val alamat: String,
    val iuranKas: String,
    val iuranKeamanan: String = "",
    val iuranKebersihan: String = "",
    val danaSosial: String = ""
)
