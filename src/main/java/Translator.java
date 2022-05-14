import java.io.*;
import java.util.HashMap;


class Dictionary {
    public HashMap<String, String> map = new HashMap<String, String>();

    public void loadRecords() {
        BufferedReader PLtoEN;
        try {
            PLtoEN = new BufferedReader(new FileReader(
                    "/Users/test/internship/dictionaries/PLtoEN.dsv"));
            String line = PLtoEN.readLine();
            while (line != null) {
                System.out.println(line);
                line = PLtoEN.readLine();
                String[] parsedLine = line.split("|");
                String EnWord = parsedLine[1];
                String PlMeaning = parsedLine[0];

                this.map.put(EnWord, PlMeaning);
            }
            PLtoEN.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader ENtoIT;
        try {
            ENtoIT = new BufferedReader(new FileReader(
                    "/Users/test/internship/dictionaries/ENtoIT.dsv"));
            String line = ENtoIT.readLine();
            while (line != null) {
                System.out.println(line);
                line = ENtoIT.readLine();
                String[] parsedLine = line.split("|");
                String EnWord = parsedLine[0];
                String ItMeaning = parsedLine[1];
                String Dictionary = map.get(EnWord);
                Dictionary = Dictionary + "|" + ItMeaning;
                this.map.put(Dictionary, ItMeaning);
            }
            ENtoIT.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String generateDictionary(String word) {
        for (String i : map.keySet()) {
            if (i == word) {
                String newWord = map.get(i);
                return newWord;
            }
        }
        return null;

    }

    public void SaveRecords() {
        BufferedWriter PLtoIT;
        try {
            PLtoIT = new BufferedWriter(new FileWriter("/Users/test/internship/dictionaries/PLtoIT.dsv"));

            for (String i : map.keySet()) {
                String w = map.get(i);
                PLtoIT.write(i);
                PLtoIT.write("|");
                PLtoIT.write(w);

            }
            PLtoIT.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    }


    public class Translator {
        public void main(String[] args) {
            Dictionary obj = new Dictionary();
            obj.loadRecords();
            System.out.println(obj.generateDictionary("piłka"));
        }
    }




