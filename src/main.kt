import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {

    //Declare and initialize variables
    var today = LocalDateTime.now()
    val dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val formattedToday = today.format(dateFormatter)

    println("Today is: $formattedToday")

    //First full moon of 2020
    val FirstFullMoon: LocalDateTime = LocalDateTime.of(2020, 1, 10, 13, 23, 14)
    val formattedFirstFullMoon = FirstFullMoon.format(dateFormatter)

    println("The first full moon of 2020 was: $formattedFirstFullMoon")

    //Create a list of all the full moons for the year using the approximate time between full moons.
    val listOfFullMoons = arrayListOf<LocalDateTime>()
    //Add January to slot 0
    listOfFullMoons.add(FirstFullMoon)
    //Add Feb to Dec to slots 1 - 12
    for (i in 0..11) {
        listOfFullMoons.add(listOfFullMoons.get(i).plusDays(29).plusHours(12).plusMinutes(44).plusSeconds(3))
    }
    println("=============== Approximation of all full moons for the year =============")
    for (x in listOfFullMoons)
        println(x.format(dateFormatter))

    //Print previous and next full moon based on system month but use correct month in list
    //Account for last moon last year and first moon next year
    println("============= Last Full Moon From Today's Date ==================")
    var monthInList: Int = today.monthValue - 1

    if (monthInList - 1 < 0)
        println(
            "The last full moon last year was: ${FirstFullMoon.minusDays(29).minusHours(12).minusMinutes(44).minusSeconds(
                3
            )}"
        )
    else
        println("The last full moon was: ${listOfFullMoons[monthInList - 1].format(dateFormatter)}")

    println("============= Next Full Moon From Today's Date ==================")
    if (monthInList + 1 > 12)
        println(
            "Next Years first full moon will be: ${listOfFullMoons.get(11).plusDays(29).plusHours(12).plusMinutes(44).plusSeconds(
                3
            )}"
        )
    else
        println("The next full moon will be: ${listOfFullMoons[monthInList + 1].format(dateFormatter)}")

}