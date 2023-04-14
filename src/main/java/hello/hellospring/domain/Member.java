package hello.hellospring.domain;

import javax.persistence.*;

@Entity
@Table(name="member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCode;

    @Column(name = "memberName")
    private String name;

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String memberId;

    private String memberPw;

    private String memberSalt;

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
