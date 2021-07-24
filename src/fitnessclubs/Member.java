package fitnessclubs;


public class Member {

    char memberType;
    int memberID;
    String name;
    double fees;

    public Member(char memberType, int memberID, String name, double fees) {
        this.memberType = memberType;
        this.memberID = memberID;
        this.name = name;
        this.fees = fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return memberType + ", " + memberID + ", " +  name + ", " + fees;
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }    
    public String toPrint() {
        return name + ", $" + fees + ", " + memberType + ", ID=" + memberID;
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }    
}
