package logica;

@SuppressWarnings("serial")

public class IngRepetidoExc extends ExceptionH{
    private String repetido;

    public IngRepetidoExc(String repetido) {
        super("Error: Ingrediente repetido - " + repetido);
        this.repetido = repetido;
    }

    public String getrepetido() {
        return repetido;
    }
}
