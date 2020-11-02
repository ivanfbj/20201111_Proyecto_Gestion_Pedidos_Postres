package software;

public class PostreHorneado extends Postre {

    private boolean esHojaldrado;

    public PostreHorneado(String nombrePostre, double cantidadDeCalorias, String fechaVencimiento, double precio, boolean esHojaldrado) {
        super(nombrePostre, cantidadDeCalorias, fechaVencimiento, precio);

        this.esHojaldrado = esHojaldrado;
    }

    @Override
    public String toString() {
        return super.toString()+ "PostreHorneado " + "esHojaldrado: " + esHojaldrado;
    }
    


}
