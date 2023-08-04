package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String,
    var code: String,
    var image: Int,
    var categoryType: CategoryTypes
): Parcelable{

}
