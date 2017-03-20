package agendamento.androidtcc.mateuscardoso.com.agendamento.model;



/**
 * Created by mateus polonini cardoso on 20/03/2017.
 */

public class Sala {

    // region FIELDS


    private String name;

    // endregion

    // region CONSTRUCTORS

    public Sala(String name) {

        this.name = name;
    }

    // endregion

    // region GETTERS AND SETTERS

    public String getName() {

        return name;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sala sala = (Sala) o;

        return (name != null && sala.getName() != null && name.equals(sala.getName()));
    }

    // endregion
}
