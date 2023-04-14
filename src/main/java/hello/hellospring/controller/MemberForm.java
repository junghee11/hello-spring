package hello.hellospring.controller;

public class MemberForm {
    private String name;
    private String memberId;
    private String memberPw;
    private String memberSalt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberSalt() {
        return memberSalt;
    }

    public void setMemberSalt(String memberSalt) {
        this.memberSalt = memberSalt;
    }
}
