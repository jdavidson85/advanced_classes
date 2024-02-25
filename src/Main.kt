enum class PositionTitle {
    Administration, Production, Maintenance
}

class Employee(val name: String, val position: PositionTitle, val salary: Boolean, val payRate: Double, val shift: Int) {
    fun calculate(hoursIn: Double): Double {
        var totalPay = 0.0
        var overtimeHours = 0.0

        if (!salary && hoursIn > 40) {
            overtimeHours = hoursIn - 40
            totalPay += 40 * payRate + overtimeHours * 1.5 * payRate
        } else {
            totalPay += hoursIn * payRate
        }

        if (shift == 2) {
            totalPay *= 1.05
        } else if (shift == 3) {
            totalPay *= 1.10
        }

        return totalPay
    }

    fun displayWeeklyPay(hoursWorked: Double) {
        val weeklyPay = calculate(hoursWorked)
        println("Employee: $name, Position: $position, Pay Rate: $$payRate, Weekly Earnings: $$weeklyPay")
    }
}

fun main() {
    val employee1 = Employee("Jacki", PositionTitle.Administration, true, 500.0, 1)
    val employee2 = Employee("Luke", PositionTitle.Production, false, 15.0, 2)
    val employee3 = Employee("Lincoln", PositionTitle.Maintenance, false, 20.0, 3)

    employee1.displayWeeklyPay(45.0)
    employee2.displayWeeklyPay(50.0)
    employee3.displayWeeklyPay(35.0)
}