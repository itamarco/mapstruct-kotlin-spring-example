package org.itamar.mapstructkotlin

import org.itamar.mapstructkotlin.model.IVehicle
import org.itamar.mapstructkotlin.model.entities.Car
import org.itamar.mapstructkotlin.model.entities.Fleet
import org.itamar.mapstructkotlin.model.entities.Taxi
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.FIELD,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface MyMappers {
    @Mapping(target = "taxiLicense", source = "license")
    fun carToTaxi(car: Car, license: String): Taxi

    fun taxiToCar(taxi: Taxi): Car

    @Mapping(target = "car", source = "car")
    @Mapping(target = "taxi", source = "taxi")
    fun carAndTaxiToFleet(car: Car, taxi: Taxi): Fleet

    fun vehicleToCar(vehicle: IVehicle): Car
}