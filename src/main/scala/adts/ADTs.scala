package adts

object ADTs {
  // way of structuring your data

  sealed trait Weather // "Sum type"
  case object Sunny extends Weather
  case object Windy extends Weather
  case object Rainy extends Weather
  case object Cloudy extends Weather

  // Weather = Sunny + Windy + Rainy + Cloudy = SUM type

  def feeling(weather: Weather): String = weather match {
    case Sunny => ":)"
    case Cloudy => ":|"
    case Rainy => ":("
  }

  // "Product Type"
  case class WeatherForecastRequest(latityde: Double, longitude: Double)
  // (Double, Double) => WFR
  // type WFR = Double x Double = Algebraic Product type

  // "Hybrid type"
  sealed trait WeatherForecastResponse
  case class Valid(weather: Weather) extends WeatherForecastResponse
  case class Invalid(error: String, description: String) extends WeatherForecastResponse

  // advantages
  // 1. illegal states are not representable
  // 2. highly composable
  // 3. immutable data structures
  // 4. just data not functionality => easier to structure code

  type NaiveWeather = String
  def naiveFeeling(weather: String): NaiveWeather = weather match {
    case "Sunny" => ":)"
    case "Cloudy" => ":|"
    case "Rainy" => ":("
  }

  naiveFeeling("45 degrees") // bad

  // complexity = number of possible values
  // goal: reduce complexity

  sealed trait WeatherServerError
  case object NotAvailable extends WeatherServerError

}
