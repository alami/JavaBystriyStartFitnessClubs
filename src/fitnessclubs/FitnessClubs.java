package fitnessclubs;

import java.util.LinkedList;

public class FitnessClubs {    
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        
        LinkedList<Member> members = fh.readFile();
        
        /*System.out.println(members.peek());
        for (int i = 1; i < members.size()-1; i++) {
            System.out.println(members.get(i));
        }
        System.out.println(members.peekLast());*/        
        //String text = "M, 4, Yudin, 1950.0, 101";
        //fh.appendFile(text);        
        //fh.overwriteFile(members);
        
        //members = mm.addMembers(members);
        //mm.printMemberInfo(members);     //System.out.println(members);
        int choice = mm.getChoice();
        while (choice != -1){
            switch (choice){
                case 1: 
                    mem = mm.addMembers(members);
                    //!!fh.appendFile(mem);
                    break;
                case 2: 
                    mm.removeMember(members);
                    //!!fh.overwriteFile(members);
                    break;
                case 3: 
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.print("\nYou have selected an invalid option.\n\n");
                    break;
            }
            choice = mm.getChoice();
        }
        System.out.println("\nGood Bye");//!!
    }    
}
