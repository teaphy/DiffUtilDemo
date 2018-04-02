package com.teaphy.diffutildemo.bean

/**
 * @desc
 * @author Tiany
 * @date  2018/3/26 0026
 */
data class DiffBean(var name: String, var desc: String) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val diff = o as DiffBean?

        return diff!!.name == name
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        return result
    }
}