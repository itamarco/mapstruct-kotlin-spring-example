package org.itamar.mapstructkotlin

import org.itamar.mapstructkotlin.model.Engine
import org.itamar.mapstructkotlin.model.IVehicle
import org.itamar.mapstructkotlin.model.VehicleType
import org.itamar.mapstructkotlin.model.entities.Car
import org.itamar.mapstructkotlin.model.entities.Taxi
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MapstructTest {
    @Autowired
    private lateinit var mapper: MyMappers

    @Test
    fun `from car to taxi`() {
        val car = Car(
            type = VehicleType.BUS,
            modelName = "i20",
            licenseTypes = listOf(1, 2),
            engine = Engine("V6")
        )

        val taxi = mapper.carToTaxi(car, "220")

        assertEquals(
            Taxi(
                type = VehicleType.BUS,
                modelName = "i20",
                licenseTypes = listOf(1, 2),
                engine = Engine("V6"),
                taxiLicense = "220"
            ),
            taxi
        )
    }

    @Test
    fun `from taxi to car`() {
        val taxi = Taxi(
            modelName = "i20",
            licenseTypes = listOf(1, 2),
            engine = Engine("V6"),
            taxiLicense = "220"
        )

        val car = mapper.taxiToCar(taxi)

        assertEquals(
            Car(
                type = VehicleType.CAR,
                modelName = "i20",
                licenseTypes = listOf(1, 2),
                engine = Engine("V6")
            ),
            car
        )
    }

    @Test
    fun `compose fleet`() {
        val car = Car(
            type = VehicleType.BUS,
            modelName = "i20",
            licenseTypes = listOf(1, 2),
            engine = Engine("V6")
        )
        val taxi = Taxi(
            modelName = "Tesla",
            licenseTypes = listOf(1, 2),
            engine = Engine("Electric"),
            taxiLicense = "220"
        )

        val fleet = mapper.carAndTaxiToFleet(car, taxi)

        assertEquals(car, fleet.car)
        assertEquals(taxi, fleet.taxi)
    }

    @Test
    fun `vehicle to car`() {
        val vehicle: IVehicle = Taxi(
            modelName = "Tesla",
            licenseTypes = listOf(2, 3),
            engine = Engine("Electric"),
            taxiLicense = "220"
        )

        val car = mapper.vehicleToCar(vehicle)

        assertEquals(
            Car(
                type = VehicleType.CAR,
                modelName = "Tesla",
                licenseTypes = listOf(2, 3),
                engine = Engine("Electric")
            ),
            car
        )
    }
}
