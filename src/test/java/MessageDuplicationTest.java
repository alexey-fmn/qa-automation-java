import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tcs.edu.domain.Duplication;
import com.tcs.edu.domain.Message;
import com.tcs.edu.service.MessageDuplication;
import org.junit.jupiter.api.Test;

public class MessageDuplicationTest {

    @Test
    public void shouldReturnArrayWhenUseWithDoubles() {
        final MessageDuplication duplicateService = new MessageDuplication();
        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(MAJOR, "111");
        Message[] messages = new Message[]{mess1, mess2};

        Message[] doublingMessages = duplicateService.messageDuplication(Duplication.DOUBLES, messages);

        assertEquals(2, doublingMessages.length);

    }

    @Test
    public void shouldReturnOneElementWhenGivenSame() {
        final MessageDuplication duplicateService = new MessageDuplication();
        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(MAJOR, "222");
        Message mess3 = new Message(MAJOR, "333");
        Message[] messages = new Message[]{mess1, mess2, mess3};

        Message[] doublingMessages = duplicateService.messageDuplication(Duplication.DISTINCT, messages);

        assertEquals(3, doublingMessages.length);
    }

    @Test
    public void shouldReturnExceptionWhenWithoutArguments() {

        final MessageDuplication duplicateService = new MessageDuplication();

        assertThrows(
            IllegalArgumentException.class,
            () -> duplicateService.messageDuplication(Duplication.DISTINCT)
        );
    }

    @Test
    public void shouldReturnTrueWhenGivenSameElements() {
        final MessageDuplication messageArray = new MessageDuplication();
        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(MAJOR, "111");

        boolean arrayOfMessages = messageArray.isMessageInArray(mess1, mess2);

        assertTrue(arrayOfMessages);
    }

    @Test
    public void shouldReturnFalseWhenGivenOtherElements() {
        final MessageDuplication messageArray = new MessageDuplication();
        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(MAJOR, "222");

        boolean arrayOfMessages = messageArray.isMessageInArray(mess1, mess2);

        assertFalse(arrayOfMessages);
    }

    @Test
    public void shpuldReturnExceptionWhenGivenWithoutArguments() {

        final MessageDuplication messageArray = new MessageDuplication();
        Message mess1 = new Message(MAJOR, "111");

        assertThrows(
            IllegalArgumentException.class,
            () -> messageArray.isMessageInArray(mess1)
        );
    }

//    @Test
//    public void shouldReturnOneElementWhenUseWithDoubles() {
//        final MessageDuplication duplicateService = new MessageDuplication();
//        Message mess0 = new Message();
//    }

}
