package org.itamar.mapstructkotlin.model

interface IVehicle {
    val type: VehicleType
    val modelName: String?
    val licenseTypes: List<Int>
    val engine: Engine
}
