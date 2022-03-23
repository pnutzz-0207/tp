package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Matric Card in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidMatricCard(String)}
 */
public class MatricCard {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code MatricCard}.
     *
     * @param cardNumber A valid cardNumber.
     */
    public MatricCard(String cardNumber) {
        requireNonNull(cardNumber);
        checkArgument(isValidMatricCard(cardNumber), MESSAGE_CONSTRAINTS);
        value = cardNumber;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidMatricCard(String test) {
        return test.equals("") || test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MatricCard // instanceof handles nulls
                && value.equals(((MatricCard) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
