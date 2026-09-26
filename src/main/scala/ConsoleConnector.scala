import DataOperation.Stop

class ConsoleConnector extends DataSource {
  var numberOfPackages: Int = 0

  def read(packageNumber : Int): DataPackage = {
    DataPackage(null, Stop)
  }

  def write(dataPackage: DataPackage): Boolean = {
    numberOfPackages += 1
    System.out.println("Output: " + String(dataPackage.bytes))
    true
  }

  override def close(): Boolean = {
    println(s"Number of packages processed by ConsoleConnector: $numberOfPackages ")
    true
  }
}
