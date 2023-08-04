package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "instructions")
data class Instruction(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var step: Int? = null,
    var instruction: String? = null
) : Parcelable {
}
