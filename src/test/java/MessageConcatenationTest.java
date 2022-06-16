import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static com.tcs.edu.decorator.SeverityLevel.MINOR;
import static com.tcs.edu.decorator.SeverityLevel.REGULAR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tcs.edu.domain.Message;
import com.tcs.edu.service.MessageConcatenator;
import org.junit.jupiter.api.Test;

public class MessageConcatenationTest {

    @Test
    public void shouldReturnMessageWithLengthThreeWhenCallConcatenation() {
        final MessageConcatenator concatenatedMessage = new MessageConcatenator();

        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(REGULAR, "222");
        Message mess3 = new Message(MINOR, "333");

        Message[] concatMessages = concatenatedMessage.messageConcatenation(mess1, mess2, mess3);

        assertEquals(3, concatMessages.length);

    }

    // нужно добавить тесты на ассерт, пока не разобрался как

}
