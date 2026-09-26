trait DataSource {
    def read(packageNumber : Int) : DataPackage;
    def write(dataPackage: DataPackage) : Boolean;
    def close(): Boolean = {true}
}
