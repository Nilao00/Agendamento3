package agendamento.androidtcc.mateuscardoso.com.agendamento.model;



/**
 * Created by mateus polonini cardoso on 20/03/2017.
 **/

public class Professor{

    // region FIELDS

    private String name;
    private double email;

    // endregion

    // region CONSTRUCTORS

    public Professor() {}

    public Professor(String name, double email) {
        this.name = name;
        this.email = email;
    }

    // endregion

    // region GETTERS AND SETTERS

    public String getName() {

        return name;
    }

    public double getDebt() {

        return email;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        final double PRECISION = 0.01;

        return
                (name != null && professor.getName() != null && name.equals(professor.getName()));
    }
    // endregion
}
