package examens.spring.spring;

public class PersonNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PersonNotFoundException(Long id) {
        super("Not found:" + id);
    }

}
