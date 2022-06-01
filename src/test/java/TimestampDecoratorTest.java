import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tcs.edu.decorator.TimestampDecorator;
import org.junit.jupiter.api.Test;

public class TimestampDecoratorTest {

    @Test
    public void shouldAddTimestampWhenCallWithString() {
        final TimestampDecorator decorator = new TimestampDecorator();

        String text = "111";
        String decoratedMessage = decorator.decorate(text);

        assertTrue(decoratedMessage.contains(text));
    }

    @Test
    public void shouldAddTimestampAtTheEndOfString() {
        final TimestampDecorator decorator = new TimestampDecorator();

        String text = "111";
        String decoratedMessage = decorator.decorate(text);

        assertEquals(-1, decoratedMessage.lastIndexOf(text.length()));

    }

}
