
public class Biblioteca {

    private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;

    private int totalItens;
    private int totalUsuarios;

    public Biblioteca(int capacidadeItens, int capacidadeUsuarios) {
        acervo = new ItemBiblioteca[capacidadeItens];
        usuarios = new Usuario[capacidadeUsuarios];

        totalItens = 0;
        totalUsuarios = 0;
    }

    public boolean cadastrarItem(ItemBiblioteca item) {
        if (totalItens >= acervo.length) {
            System.out.println("Acervo cheio!");
            return false;
        }

        acervo[totalItens] = item;
        totalItens++;

        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (totalUsuarios >= usuarios.length) {
            System.out.println("Limite de usuários atingido!");
            return false;
        }

        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;

        return true;
    }

    public boolean emprestar(int codigo, Usuario usuario) {

        if (usuario == null || !usuario.podeEmprestar()) {
            System.out.println("Empréstimo recusado: limite atingido.");
            return false;
        }

        for (int i = 0; i < totalItens; i++) {

            if (acervo[i].getCodigo() == codigo) {

                if (!acervo[i].isDisponivel()) {
                    System.out.println("Item indisponível.");
                    return false;
                }

                acervo[i].emprestarItem();
                usuario.registrarEmprestimo();

                System.out.println("Empréstimo realizado: "
                        + acervo[i].getTitulo());

                return true;
            }
        }

        System.out.println("Item não encontrado.");
        return false;
    }

    public boolean devolver(int codigo, Usuario usuario) {

        if (usuario == null) {
            System.out.println("Usuário inválido.");
            return false;
        }

        for (int i = 0; i < totalItens; i++) {

            if (acervo[i].getCodigo() == codigo) {

                if (acervo[i].isDisponivel()) {
                    System.out.println("O item já está disponível.");
                    return false;
                }

                acervo[i].devolverItem();
                usuario.registrarDevolucao();

                System.out.println("Devolução realizada: "
                        + acervo[i].getTitulo());

                return true;
            }
        }

        System.out.println("Item não encontrado.");
        return false;
    }

    public void listarAcervo() {

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");

        for (int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i]);
        }
    }
}
