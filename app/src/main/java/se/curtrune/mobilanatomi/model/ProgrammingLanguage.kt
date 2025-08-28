package se.curtrune.mobilanatomi.model

import androidx.room.Entity

@Entity
data class ProgrammingLanguage(
    val name: String,
    val creator: String
)

