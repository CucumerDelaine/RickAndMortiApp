package com.example.filmapps.presentation.model

data class ConvertCharacterDetails(
    val name: String?,
    var status: String?,
    var species: String?,
    var gender: String?,
    var origin: String?,
    var location: String?,
    var image: String?
) {
    val _name = "Имя - $name"
    val _status = "Статус - $status"
    val _species = "Раса - $species"
    val _gender = "Пол - $gender"
    val _origin = "Место происхождения - $origin"
    val _location = "Местонахождение - $location"
}
