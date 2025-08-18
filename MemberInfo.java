package Library_Management_App;

public class MemberInfo {
    String memberId;
    String memberName;
    Long number;

    public MemberInfo(String memberId, String memberName, Long number) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.number = number;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public Long getNumber() {
        return number;
    }
    public String toString(){
        return "ID: "+memberId+" | Name: "+memberName+" | Contact: "+number;
    }
}
