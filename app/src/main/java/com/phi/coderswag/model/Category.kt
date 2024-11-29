package com.phi.coderswag.model

import java.io.Serializable

class Category(val title: String, val image: String): Serializable {

    override fun toString(): String {
        return title
    }
}