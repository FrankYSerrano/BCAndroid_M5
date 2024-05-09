package com.example.sismocontrol.entities

data class Sismo (
    val id: String,
    val lugar: String,
    val magnitud: Double,
    val time: Long = 0,
    val longitud: Double = 0.0,
    val latitud: Double = 0.0
    ){
    companion object{
        val dataSismos = mutableListOf(
            Sismo("s1", "Los Andes - Chile", 4.2),
            Sismo("s2", "La calera - Chile", 4.8),
            Sismo("s3", "Valparaiso - Chile", 3.2),
            Sismo("s4", "Salamanca - Chile", 5.4),
            Sismo("s5", "Puatendo - Chile", 4.2),
            Sismo("s6", "Calama - Chile", 2.2),
            Sismo("s7", "Curico - Chile", 6.6),
            Sismo("s8", "San Vicente Tagua Tagua - Chile", 3.4),
            Sismo("s9", "Talca - Chile", 5.8),
            Sismo("s5", "Puatendo - Chile", 4.2),
            Sismo("s6", "Calama - Chile", 2.2),
            Sismo("s7", "Curico - Chile", 6.6),
            Sismo("s8", "San Vicente Tagua Tagua - Chile", 3.4),
            Sismo("s9", "Talca - Chile", 5.8),
            Sismo("s5", "Puatendo - Chile", 4.2),
            Sismo("s6", "Calama - Chile", 2.2),
            Sismo("s7", "Curico - Chile", 6.6),
            Sismo("s8", "San Vicente Tagua Tagua - Chile", 3.4),
            Sismo("s9", "Talca - Chile", 5.8),
            Sismo("s5", "Puatendo - Chile", 4.2),
            Sismo("s6", "Calama - Chile", 2.2),
            Sismo("s7", "Curico - Chile", 6.6),
            Sismo("s8", "San Vicente Tagua Tagua - Chile", 3.4),
            Sismo("s9", "Talca - Chile", 5.8),
            Sismo("s10", "Concepción - Chile", 4.0)
        )

        val dataEmpty = mutableListOf<Sismo>()
    }
}