package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static hello.core.member.Grade.BASIC;
import static hello.core.member.Grade.VIP;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    @Test
    void createOrder() {
        Member member = new Member(1L,"spring", VIP);
        Member member2 = new Member(2L, "spring2", BASIC);

        memberService.join(member);
        memberService.join(member2);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        Order order2 = orderService.createOrder(member2.getId(), "itemA", 10000);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
        Assertions.assertThat(order2.calculatePrice()).isEqualTo(10000);
    }
}