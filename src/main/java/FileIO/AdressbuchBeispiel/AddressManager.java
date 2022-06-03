package FileIO.AdressbuchBeispiel;

import java.io.*;
import java.util.ArrayList;

public class AddressManager {

    private ArrayList<Address> addresses;


    public AddressManager() {
        this.addresses = new ArrayList<>();
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void loadFromCsv(String path, String seperator) throws AddressLoadException{

        File file = new File(path);

        try(
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file)))){

            String line;
            String[] lineParts;

            while((line = br.readLine()) != null){


                lineParts = line.split(seperator);

                try {
                    String firstname = lineParts[0];
                    String lastname = lineParts[1];
                    String mobilenumber = lineParts[2];
                    String email = lineParts[3];

                    Address address = new Address(firstname,lastname,mobilenumber,email);
                    addresses.add(address);
                } catch (NullPointerException x){
                    throw new AddressLoadException();
                }

            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void exportToCsv(String path, String seperator) throws AddressExportFileAlreadyExistsException, AddressExportException {

        File file = new File(path);

        if(file.exists())
            throw new AddressExportFileAlreadyExistsException();


        try(BufferedWriter bw = new BufferedWriter(
                new PrintWriter(
                        new FileWriter(file)))) {

            for (Address a:addresses) {
                String firstname = a.getFirstname();
                String lastname = a.getLastname();
                String mobilenumber = a.getMobilNumber();
                String email = a.getEmail();

                bw.write(firstname+seperator+lastname+seperator+mobilenumber+seperator+email);
                bw.newLine();
            }


        }catch (IOException e){
            throw new AddressExportException();
        }
    }

    public void add(Address a){
        this.addresses.add(a);
    }
}
