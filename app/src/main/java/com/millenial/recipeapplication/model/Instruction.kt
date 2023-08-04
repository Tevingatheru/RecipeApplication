package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = "instructions",
    foreignKeys = [ForeignKey(entity = Recipe::class,
        parentColumns = arrayOf("recipeId"),
        childColumns = arrayOf("recipeId"),
        onDelete = CASCADE
    )]
)
data class Instruction(
    @PrimaryKey(autoGenerate = true)
    var instructionId: Long? = null,
    var step: Int? = null,
    var instruction: String? = null,
    var recipeId: Long? = null
) : Parcelable {
}
