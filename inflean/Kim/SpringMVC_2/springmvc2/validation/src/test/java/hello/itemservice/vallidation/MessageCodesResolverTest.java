package hello.itemservice.vallidation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {
    // 이게 뭐냐면 에러코드를 넣으면 여러개를 반환해준다.
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver(); // 인터페이스 MessageCodesResolver 구현체 DefaultMessageCodesResolver

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        //bindingResult.rejectValue("itemName", "required");
        /*
            rejectValue 안에서 resolveMessageCodes 4가지가 호출된다.
         */

        );
    }
}
