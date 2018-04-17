package fr.jdrape.kata.berlinclockkata.enumeration;

/**
 * Enum of states lam
 * 
 * @author jdrape
 *
 */
public enum EnumLampState {

    OFF("O"), YELLOW("Y"), RED("R");

    private String code;

    private EnumLampState(final String code) {
        this.code = code;
    }

    /**
     * Return the state code.
     * 
     * @return the code
     */
    public String getCode() {
        return code;
    }
}
