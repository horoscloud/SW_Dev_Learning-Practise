package Übungen.Hangman;

import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;

public class HangmanClient implements Runnable{

    private Game game;
    private Socket client;
    private String name;

    public HangmanClient(Socket client) {
        this.client = client;
        this.name = "";
        this.game = new Game();
    }

    public void start() throws DataFileException {
    try(BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(client.getOutputStream()));
    BufferedReader br = new BufferedReader(
            new InputStreamReader(client.getInputStream()))) {

        String cmd;
        String[] cmds;
        while ((cmd = br.readLine()) != null){

            cmds = cmd.split(" ");

            if(cmds[0].equals("NAME") && name.equals("")){
                name = cmds[1];
            }else{
                bw.write("Bitte mittels Befehl ‚NAME name‘Ihren Spielernamen zuerst setzen!");
                bw.newLine();
                bw.flush();
            }

            if(cmds[0].equals("TRY")){
                if(cmds.length == 2){
                    char c = cmds[1].charAt(0);
                    game.loadWord();
                    game.tryCharacter(c);

                    if(game.isFinished()){
                        bw.write("Gratulation! Gesuchtes Wort erfolgreich gefunden. Neues Game startet...");
                        bw.newLine();
                        bw.flush();
                    }
                }else{
                    bw.write("Falsche Eingabe! 'TRY z'");
                    bw.newLine();
                    bw.flush();
                }
            }

            if (cmd.equals("EXIT")){
                client.close();
            }else {
                bw.write("Falsche Eingabe!");
            }

        }
    }catch (IOException x){
        throw new DataFileException("Wortliste kann nicht geladen werden", x);
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
