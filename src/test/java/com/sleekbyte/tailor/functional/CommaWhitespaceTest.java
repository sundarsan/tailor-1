package com.sleekbyte.tailor.functional;


import com.sleekbyte.tailor.common.Messages;
import com.sleekbyte.tailor.common.Rules;
import com.sleekbyte.tailor.common.Severity;
import com.sleekbyte.tailor.output.Printer;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommaWhitespaceTest extends RuleTest {

    @Override
    protected String[] getCommandArgs() {
        return new String[]{ "--only=comma-whitespace" };
    }

    @Override
    protected void addAllExpectedMsgs() {
        // Type inheritance commas
        int start = 9;
        addExpectedCommaMessage(start, 24, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 4, 23, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 8, 23, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 16, 33, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 29, 22, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 37, 17, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 42, 53, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 46, 22, Messages.NO_SPACE_BEFORE);

        // Generic list commas
        start = 63;
        addExpectedCommaMessage(start, 31, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 31, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 8, 32, Messages.NO_SPACE_BEFORE);

        // Requirement list commas
        start = 82;
        addExpectedCommaMessage(start, 37, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 43, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 43, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 8, 1, Messages.NO_SPACE_BEFORE);

        // Condition clause/list commas
        start = 103;
        addExpectedCommaMessage(start, 10, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 4, 34, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 8, 27, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 16, 28, Messages.NO_SPACE_BEFORE);

        // Optional binding list
        start = 131;
        addExpectedCommaMessage(start, 49, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 50, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 9, 24, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 9, 47, Messages.SPACE_AFTER);

        // Availability conditions and Generic Arguments
        start = 148;
        addExpectedCommaMessage(start, 31, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 21, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 12, 33, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 14, 32, Messages.SPACE_AFTER);

        // Pattern initializer list and parameter list
        start = 166;
        addExpectedCommaMessage(start, 14, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 2, 13, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 8, 23, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 10, 23, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 10, 30, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 12, 30, Messages.NO_SPACE_BEFORE);

        // Enum case lists
        start = 189;
        addExpectedCommaMessage(start, 17, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start, 36, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 47, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 13, 21, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 18, 20, Messages.SPACE_AFTER);

        // Tuple patterns
        start = 213;
        addExpectedCommaMessage(start, 7, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start, 17, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 2, 11, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 2, 11, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 2, 20, Messages.SPACE_AFTER);

        // Expression lists
        start = 223;
        addExpectedCommaMessage(start, 11, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 11, Messages.SPACE_AFTER);
        addExpectedCommaMessage(start + 4, 46, Messages.NO_SPACE_BEFORE);
        addExpectedCommaMessage(start + 8, 46, Messages.NO_SPACE_BEFORE);

    }

    private void addExpectedCommaMessage(int line, int column, String msg) {
        addExpectedMsg(Rules.COMMA_WHITESPACE, line, column, Messages.COMMA + Messages.AT_COLUMN + column + " " + msg);
    }

    private void addExpectedMsg(Rules rule, int line, int column, String msg) {
        this.expectedMessages.add(Printer.genOutputStringForTest(rule, inputFile.getName(), line, column,
            Severity.WARNING, msg));
    }
}
