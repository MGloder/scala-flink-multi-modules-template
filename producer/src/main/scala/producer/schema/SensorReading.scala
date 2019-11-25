package producer.schema

case class SensorReading(id: String, reading: Float, timestamp: Long) extends Serializable
