package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("zenguygguihbia");
        member.setMemberId("fwiafhioawhfiwhg");
        member.setMemberPw("wfoiejiowjafowfaw");
        member.setMemberSalt("awhfiwhifhiawfhw");

        // when
        Long saveId = memberService.join(member);
        
        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        System.out.println("findMember.getMemberCode() = " + findMember.getMemberCode());
    }

    @Test
    public void exceptionDuplicatedMember(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        member1.setMemberId("fwiafhioawhfiwhg1");
        member1.setMemberPw("wfoiejiowjafowfaw1");
        member1.setMemberSalt("awhfiwhifhiawfhw1");

        Member member2 = new Member();
        member2.setName("spring1");
        member2.setMemberId("fwiafhioawhfiwhg2");
        member2.setMemberPw("wfoiejiowjafowfaw2");
        member2.setMemberSalt("awhfiwhifhiawfhw2");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));

//        try {
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}