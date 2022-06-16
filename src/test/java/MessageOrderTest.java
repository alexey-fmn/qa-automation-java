import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static com.tcs.edu.decorator.SeverityLevel.REGULAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;
import com.tcs.edu.service.MessageOrder;
import org.junit.jupiter.api.Test;

public class MessageOrderTest {


    @Test
    public void shouldReturnSameArrayWhenASC() {
        final MessageOrder orderService = new MessageOrder();
        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(REGULAR, "222");

        Message[] orderedMessages = orderService.sortMessages(Sorting.ASC, mess1, mess2);

        assertEquals(mess1, orderedMessages[0]);

    }

    @Test
    public void shouldReturnOrderedArrayWhenDesc() {
        final MessageOrder orderService = new MessageOrder();
        Message mess1 = new Message(MAJOR, "111");
        Message mess2 = new Message(REGULAR, "222");

        Message[] orderedMessages = orderService.sortMessages(Sorting.DESC, mess1, mess2);

        assertNotEquals(mess1, orderedMessages[0]);
    }

    // нужно добавить тесты на ассерт, пока не разобрался как
}
