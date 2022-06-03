package FileIO.AdressbuchBeispiel;

public class AddressDemo {
    public static void main(String[] args) throws AddressLoadException, AddressExportException, AddressExportFileAlreadyExistsException {

        AddressManager am = new AddressManager();

        am.loadFromCsv("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\testdaten-adressbuch.csv", ";");

        Address a = new Address("YOLO", "MAN", "9999999", "rofl@rofl.rofl");

        am.add(a);

        am.exportToCsv("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\testdaten-adressbuch_02.csv", "--");
    }
}
