import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeverityDecoratorTest {

    @Test
    public void shouldReturnStringWithoutExclamationWhenCallWithMinor() {

        final SeverityDecorator severity = new SeverityDecorator(SeverityLevel.MINOR);
        String severityMark = "( )";
        String decoratedMessage = "111";

        String decoratedText = severity.decorate(decoratedMessage);

        Assertions.assertTrue(decoratedText.contains(severityMark));

    }

    @Test
    public void shouldReturnStringWithOneExclamationWhenCallWithRegular() {

        final SeverityDecorator severity = new SeverityDecorator(SeverityLevel.REGULAR);
        String severityMark = "(!)";
        String decoratedMessage = "111";

        String decoratedText = severity.decorate(decoratedMessage);

        Assertions.assertTrue(decoratedText.contains(severityMark));

    }

    @Test
    public void shouldReturnStringWithThreeExclamationWhenCallWithMajor() {

        final SeverityDecorator severity = new SeverityDecorator(SeverityLevel.MAJOR);
        String severityMark = "(!!!)";
        String decoratedMessage = "111";

        String decoratedText = severity.decorate(decoratedMessage);

        Assertions.assertTrue(decoratedText.contains(severityMark));

    }

    @Test
    public void shouldReturnStringWithExclamationAtFirstPointWhenCallWithSeverity() {

        final SeverityDecorator severity = new SeverityDecorator(SeverityLevel.MAJOR);
        String decoratedMessage = "111";

        String decoratedText = severity.decorate(decoratedMessage);

        assertEquals(-1, decoratedMessage.lastIndexOf(decoratedText.length()));

    }

}
