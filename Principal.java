import model.*;

public class Principal {
    public static void main(String[] args) {
        try {
            // Pessoas Físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Ana", "123.456.789-00", 28));
            repo1.inserir(new PessoaFisica(2, "Carlos", "987.654.321-00", 35));
            repo1.persistir("pessoas_fisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");
            System.out.println("\n--- Pessoas Físicas Recuperadas ---");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
                System.out.println();
            }

            // Pessoas Jurídicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Empresa Sales 1", "12.345.678/0001-00"));
            repo3.inserir(new PessoaJuridica(2, "Empresa Sales 2", "98.765.432/0001-00"));
            repo3.persistir("pessoas_juridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");
            System.out.println("\n--- Pessoas Jurídicas Recuperadas ---");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}