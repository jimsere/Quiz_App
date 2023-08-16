package com.example.quizzapp5177

data class Employee(
    val name: String,
    val surname: String,
    val speciality: String
)

object EmployeeList {

    fun getEmployees(): ArrayList<Employee> {
        val employeeList = ArrayList<Employee>()

        val employee1 = Employee(
            "Kostas",
            "Tsiknas",
            "Engineer"
        )
        employeeList.add(employee1)

        val employee2 = Employee(
            "Nick",
            "Mastoras",
            "Director"
        )
        employeeList.add(employee2)

        return employeeList
    }

}


fun main() {

    println ("accessing employee name")
    println ("---------")
    var i  = 0
    println ("name: ${EmployeeList.getEmployees()[i].name}")
    i++
    println ("name: ${EmployeeList.getEmployees()[i].name}")

    println ("accessing employee name using for loop")
    println ("--------------------------------------")
    for(i in 0 until EmployeeList.getEmployees().size)
    {
        println ("name: ${EmployeeList.getEmployees()[i].name}")
    }

}
