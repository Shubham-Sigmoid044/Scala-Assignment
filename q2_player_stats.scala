package Exercise
import scala.collection.immutable.ListMap


import scala.annotation.tailrec

object scala_assignment extends App {

  // All the data
  val player_stats = Array(Array("2021", "Sam", "India", "23", "2300", "3"),
    Array("2021", "Ram", "India", "23", "300", "30"),
    Array("2021", "Mano", "India", "23", "300", "13"),
    Array("2021", "Tim", "Australia", "23", "1213", "103"),
    Array("2021", "Gary", "England", "29", "4262", "78"),
    Array("2021", "Steve", "Ireland", "33", "12", "34"),
    Array("2021", "Lotso", "South Africa", "22", "3000", "3"),
    Array("2021", "Joe", "England", "23", "123", "130")
  )
  
  
  // created mutable map the map
  val run_score = scala.collection.mutable.Map.empty[String,Int]
  val wickets_taken = scala.collection.mutable.Map.empty[String,Int]
  val rank = scala.collection.mutable.Map.empty[String,Int]

  
  // created map to store all the value.
  player_stats.foreach(x => {
    run_score += x(1) -> x(4).toInt
    wickets_taken += x(1) -> x(5).toInt
    rank += (x(1)->(x(5).toInt*5 + x(4).toInt*(5/100)).toInt)
  })


  val res1 = ListMap(run_score.toSeq.sortWith(_._2 > _._2):_*)
  val res2 = ListMap(wickets_taken.toSeq.sortWith(_._2 > _._2):_*)
  val res3 = ListMap(rank.toSeq.sortWith(_._2 > _._2):_*)


  // Player with highest run scored

  val highest_score = res1.head

  println(highest_score)
  println()


  // Top 5 players by run scored.

  println("Top 5 players by run scored.")
  println()

  for((key,value) <- res1.take(5)) {
    println(key + " has scored " + value)
  }

  println("Top 5 players by wicket taken.")
  println()

  // Top 5 players by wicket taken.

  for((key,value) <- res2.take(5)) {
    println(key + " has " + value + "wickets.")
  }

  println("Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.")
  println()

  // Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.

  for((key,value) <- res3.take(5)) {
    println(key + " has overall performance " + value)
  }


}

