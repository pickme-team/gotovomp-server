package com.ligon.deeznuts.models.dao

import com.ligon.deeznuts.tables.Tags
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TagDao(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<TagDao>(Tags)

    var tag by Tags.tag
    var recipe by RecipeDao referencedOn Tags.recipe
}
