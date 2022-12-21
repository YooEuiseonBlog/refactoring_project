package jpabook.jpashoptwo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void memberTest() {
        Member member = Member.builder()
                .name("yoo")
                .address(Address.builder()
                        .city("seoul")
                        .street("jongro")
                        .zipcode("1402")
                        .build())
                .build();
        em.persist(member);
        em.flush();
        em.clear();
        Member foundMember = em.find(Member.class, member.getId());
    }
}