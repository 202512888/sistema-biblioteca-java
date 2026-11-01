public class DVD extends ItemBiblioteca {

    public DVD(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDevolucao() {
        return 3;
    }

    @Override
    public double getMultaDiaria() {
        return 2.00;
    }
}