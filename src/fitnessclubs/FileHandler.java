package fitnessclubs;
import java.util.LinkedList;
import java.io.*;
public class FileHandler {
    public LinkedList<Member> m = new LinkedList();
    private String lineRead;
    private String[] splitLine;
    private Member mem;
    private char memberType;
    
    public LinkedList<Member> readFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))){
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(", ");
                //System.out.println(lineRead);
                //System.out.println(splitLine[0] + " | "+splitLine[1] + " | "+splitLine[2] + " | "+splitLine[3]);                
                memberType = splitLine[0].charAt(0);
                if (memberType =='S')  //char memberType, int memberID, String name, double fees, int club
                    mem = new SingleClubMember(memberType, Integer.parseInt(splitLine[1]), 
                    splitLine[2],Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));                
                else         //char memberType, int memberID, String name, double fees, int membershipPoints
                    mem = new MultiClubMember(memberType, Integer.parseInt(splitLine[1]), 
                    splitLine[2],Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));                
                m.add(mem);
                lineRead = reader.readLine();  //прострочное чтение
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }
    public void appendFile(String mem) {               
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(mem);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void overwriteFile(LinkedList<Member> mem) {
        String text;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
            for (int i = 0; i < mem.size(); i++) {
                text = mem.get(i).toString();
                writer.write(text);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            File f = new File("members.csv");
            File tf = new File("members.temp");
            f.delete();
            tf.renameTo(f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
}
