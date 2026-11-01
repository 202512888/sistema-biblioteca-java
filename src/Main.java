
public class Main {

    public static void main(String[] args) {

        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca(10, 5);

        // Cadastrando livros e revistas
        biblioteca.cadastrarItem(new Livro(1, "Dom Casmurro"));
        biblioteca.cadastrarItem(new Livro(2, "O Pequeno Principe"));
        biblioteca.cadastrarItem(new Revista(3, "National Geographic"));
        biblioteca.cadastrarItem(new Revista(4, "Superinteressante"));
        biblioteca.cadastrarItem(new DVD(5, "Interestelar"));
        // Cadastrando usuários
        Aluno aluno = new Aluno("Bruna");
        Professor professor = new Professor("Carlos");

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        // Empréstimos do aluno
        System.out.println("=== EMPRESTIMOS DO ALUNO ===");

        biblioteca.emprestar(1, aluno);
        biblioteca.emprestar(2, aluno);
        biblioteca.emprestar(3, aluno);

        // Tentativa de quarto empréstimo
        biblioteca.emprestar(4, aluno);

        // Empréstimo do professor
        System.out.println("\n=== EMPRESTIMO DO PROFESSOR ===");

        biblioteca.emprestar(4, professor);
        biblioteca.emprestar(5, professor);
        // Listando o acervo
        biblioteca.listarAcervo();
    }
}
