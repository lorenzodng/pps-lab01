package example.model;

/**
 * This class represents the account holder concept.
 * That is: a person that can subscribe a bank account.
 *
 * Each account holder has a name, a surname and an ID (unique in the bank system)
 */
public class AccountHolder {

    private final int ID;
    private final String NAME;
    private final String SURNAME;

    public AccountHolder(final String NAME, final String SURNAME, final int ID) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.ID = ID;
    }

    /**
     * Retrieve the name of the person registered as possible account holder
     * @return the name of the holder
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * Retrieve the surname of the person registered as possible account holder
     * @return the surname of the holder
     */
    public String getSURNAME() {
        return this.SURNAME;
    }

    /**
     * Retrieve the ID of the person registered as possible account holder
     * @return the id of the holder
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Provides a string representation
     * @return the string representation for an AccountHolder instance
     */
    public String toString() {
        return "ID: " +this.ID+ " - " +this.NAME+ " " +this.SURNAME;
    }
}
