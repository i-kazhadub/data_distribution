case class DataPackage(bytes: Array[Byte], operation: DataOperation, operationParameters: Map[String, String] = null)
enum DataOperation:
  case Package, Wait, Stop