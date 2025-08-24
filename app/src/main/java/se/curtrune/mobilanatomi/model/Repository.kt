package se.curtrune.mobilanatomi.model

object Repository {
    val programmingLanguages = mutableListOf(
        ProgrammingLanguage("Kotlin", "JetBrains"),
        ProgrammingLanguage("Java", "Gosling"),
        ProgrammingLanguage("C++", "Bjarne Stroustrup"))

    fun addLanguage(language: ProgrammingLanguage){
        println("Repository.AddLanguage $language")
        programmingLanguages.add(language)
    }
    fun deleteLanguage(language: ProgrammingLanguage){
        programmingLanguages.remove(language)
    }
    fun updateLanguage(language: ProgrammingLanguage){
        programmingLanguages.remove(language)
        programmingLanguages.add(language)
    }
}