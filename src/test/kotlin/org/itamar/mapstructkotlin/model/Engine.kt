package org.itamar.mapstructkotlin.model

class Engine(val model: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Engine

        if (model != other.model) return false

        return true
    }

    override fun hashCode(): Int {
        return model.hashCode()
    }

}
