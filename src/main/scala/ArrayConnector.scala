import DataOperation.{Package, Stop}

class ArrayConnector extends DataSource {
  def array = List("1", "2", "3", "4", "5", "6", "7", "8", "9")

  def read(packageNumber : Int): DataPackage = {
    var dataPackage: DataPackage = null
    if (packageNumber < array.length) {
      dataPackage = DataPackage(array(packageNumber).getBytes(), Package)
    } else {
      dataPackage = DataPackage(null, Stop)
    }
    dataPackage
  }

  def write(dataPackage: DataPackage): Boolean = {
    Thread.sleep(5000)
    false
  }

}
