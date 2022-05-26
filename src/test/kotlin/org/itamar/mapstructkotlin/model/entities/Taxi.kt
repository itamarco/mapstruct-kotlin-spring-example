package org.itamar.mapstructkotlin.model.entities

import org.itamar.mapstructkotlin.model.Engine
import org.itamar.mapstructkotlin.model.IVehicle
import org.itamar.mapstructkotlin.model.VehicleType

data class Taxi(
    override val type: VehicleType = VehicleType.CAR,
    override val modelName: String?,
    override val licenseTypes: List<Int>,
    override val engine: Engine,
    val taxiLicense: String
) : IVehicle
