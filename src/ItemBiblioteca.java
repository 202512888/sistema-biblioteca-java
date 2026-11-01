public abstract class ItemBiblioteca {
    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    void emprestarItem() {
        disponivel = false;
    }

    void devolverItem() {
        disponivel = true;
    }

    public abstract int getPrazoDevolucao();

    public abstract double getMultaDiaria();

    @Override
    public String toString() {
return "Código: " + codigo
        + " | Título: " + titulo
        + " | Disponível: " + (disponivel ? "Sim" : "Não")
        + " | Prazo: " + getPrazoDevolucao() + " dias"
        + " | Multa diária: R$ " + String.format("%.2f", getMultaDiaria());
    }
}