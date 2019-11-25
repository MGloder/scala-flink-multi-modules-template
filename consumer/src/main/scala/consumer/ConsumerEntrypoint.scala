package consumer

object ConsumerEntrypoint {
  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.addSource(new SensorReadingGenerator).print()

    env.execute()
  }

  case class Person(id: Int)

}
