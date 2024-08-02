package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void test() {
        String[] strings = codesResolver.resolveMessageCodes("required", "item");
        assertThat(strings).containsExactly("required.item", "required");
    }

    @Test
    void test2() {
        String[] strings = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        assertThat(strings).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
