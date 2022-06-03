package Übungen.ecom;

import Übungen.Hangman.DataFileException;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class EcommerceLogic implements Runnable{

    Socket client;
    BasketDataLoad basketDataLoad;
    BasketAnalyzer analyzer;

    public EcommerceLogic(Socket client) {
        this.client = client;
        basketDataLoad = new BasketDataLoad();
    }

    @Override
    public void run() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){

            String cmd;
            String[] cmds;
            while ((cmd = br.readLine()) != null){

                cmds = cmd.split(" ");


                if(cmds[0].equals("OpenFile")){

                    try {
                        analyzer = new BasketAnalyzer(basketDataLoad.load(cmds[1], new BasketComparator()));
                        bw.write("<< basket data loaded with " + analyzer.getEveryNthBasket(1).size() + " entries >>");
                        bw.newLine();
                        bw.flush();
                    }catch (DataFileException e) {
                        bw.write("Couldn't find file with entered path, please try again.");
                        bw.newLine();
                        bw.flush();
                        e.printStackTrace();
                    }

                }

                if(cmds[0].equals("GetEveryNth")){
                    if(!(cmds.length == 2 && analyzer == null)){
                        bw.write("<< basket data loaded with " + analyzer.getEveryNthBasket(Integer.parseInt(cmds[1])).toString() + " entries >>");
                        bw.newLine();
                        bw.flush();
                    }else{
                        bw.write("Couldn't find data, please select a dataset with 'OpenFile <path>' first.");
                        bw.newLine();
                        bw.flush();
                    }

                }

                if(cmd.equals("GetStats")){
                    HashMap<String, ArrayList<Double>> hashMap = analyzer.groupByProductCategory();

                    ArrayList<Double> arrayList = new ArrayList<>();

                    double gesamt = 0;
                    int count = 0;

                    for (String key:hashMap.keySet()) {

                            arrayList = hashMap.get(key);
                            for (Double d:arrayList) {
                                gesamt += d;
                                count++;

                        }
                        bw.write(key + " - " + gesamt/count);
                        bw.newLine();

                    }
                    bw.flush();
                }


                if(cmd.equals("EXIT")){
                   client.close();
                }else{
                    bw.write("Eingabeattribut nicht erkannt!");
                    bw.newLine();
                    bw.flush();
                }


            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
