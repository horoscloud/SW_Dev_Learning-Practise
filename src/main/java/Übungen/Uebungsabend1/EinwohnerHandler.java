package Übungen.Uebungsabend1;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerHandler implements Runnable{

    private Socket client;
    private EinwohnerManager ew;

    public EinwohnerHandler(Socket client) {
        this.client = client;
        this.ew = new EinwohnerManager();
    }

    public void start() throws DataFileException {

        ArrayList<Einwohner> einwohner = ew.load();

        System.out.println("Warte auf Kommando von Client: ");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){

            String cmd;
            while ((cmd = br.readLine()) != null){

                writeData(cmd, einwohner, bw);

                if(cmd.equals("EXIT")){
                   client.close();
                }

            }
        }catch (IOException x){
            throw new DataFileException("Error", x);
        }
    }

    public void writeData(String cmd, ArrayList<Einwohner> einwohnerArrayList, BufferedWriter bw) {

        System.out.println("cmd= "+cmd);
        String[] cmds = cmd.split(" ");


        try {
            if(cmds[0].equals("GET")){

                System.out.println("Bearbeite Anfrage: "+cmd);

                if(cmds.length >= 2) {
                    if(cmds.length > 2 && cmds[2].equals("order") && cmds[3].equals("by")){
                        switch (cmds[4]){
                            case "name": Collections.sort(einwohnerArrayList, new EinwohnerComparator()); break;
                            default:
                                bw.write("no such sorting possible");
                                bw.newLine();
                                bw.flush();
                                break;
                        }
                    }
                    for (Einwohner e : einwohnerArrayList) {
                        if (e.getBundesland().equals(cmds[1])) {

                            bw.write(e.toString());
                            bw.newLine();
                        }

                        if (String.valueOf(e.getGeburtsjahr()).equals(cmds[1])) {

                            bw.write(e.toString());
                            bw.newLine();
                        }
                    }
                }else{
                    bw.write("GET <command> not known");
                    bw.newLine();
                }
                bw.flush(); //!!!!!

            }else{
                bw.write("Wrong input!");
                bw.newLine();
                bw.flush();
            }
        }catch (IOException x){
            x.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            start();
        } catch (DataFileException e) {
            e.printStackTrace();
        }
    }
}
