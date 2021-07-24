package fitnessclubs;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner reader = new Scanner(System.in);
    

    private int getIntInput() {
        int choice = 0; //!!reader.nextLine(); //читает весь ввод, который не был поглощен ранее
        while (choice == 0) {
            try {
                // Программа запрашивает целое число у пользователя
                ////System.out.print("\nPls,input you choice: ");
                choice = reader.nextInt(); //reader.nextLine();
                if (choice == 0) 
                    throw new InputMismatchException();
                reader.nextLine(); //читает весь ввод, который не был поглощен ранее!!
            } catch (InputMismatchException e) {
                // Пользователю предлагается ввести новое значение
                //!!reader.nextLine(); //читает весь ввод, который не был поглощен ранее
                System.out.println("Pls,input only integer!");
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER\n"
                + "================================\n"
                + "1) Add Member\n"
                + "2) Remove Member\n"
                + "3) Display Member Information\n"
                + "Please select an option (or Enter -1 to quit): ");
        return getIntInput();
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;
        
        System.out.println("Insert member's name: "); 
        name = reader.nextLine();
        
        printClubOptions();        
        System.out.print("\nPlease enter the member's clubID: "); //!!
        club = getIntInput(); //!!club = getChoice();
        //!! if (club == -1) { System.out.println("Done"); return m; }
        while (club < 1 || club > 4) {
            System.out.println("No such club! Please\n try again:");
            club = getIntInput();
        }
        if (m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;                                        
        
        if (club != 4) {
            // Добавление посетителя одного клуба
            cal = (n) -> {  //вычислить оплату
                switch (n) {
                case 1:
                    return 900; //Club Mercury
                case 2:
                    return 950; // Club Neptune
                case 3:
                    return 1000; //Club Jupiter
                default:
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees,club);
            }
        else {
            // Добавление посетителя нескольких клубов
            cal = (n) -> {  //вычислить оплату
                switch (n) {
                case 4:
                    return 1200; 
                default:
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100 );
            }
        m.add(mbr);
        mem = mbr.toString();
        System.out.println("\nSTATUS: Club Member added\n");
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.println("Insert member ID for delete it:");
        memberID = getIntInput();
        for (int i = 0; i<m.size();i++) {
            if (m.get(i).getMemberID() == memberID){
                m.remove(i);
                return;
            }
        }
        System.out.println("member ID was not found!");
        return;
    }

    public void printMemberInfo(LinkedList<Member> m) {
        for (int i = 0; i<m.size();i++) {
            System.out.println(m.get(i).toPrint()+"\n"); 
        }
    return;
    }
}
