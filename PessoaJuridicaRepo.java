package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoas = new ArrayList<>();

    public void inserir(PessoaJuridica p) {
        pessoas.add(p);
    }

    public void alterar(PessoaJuridica p) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == p.getId()) {
                pessoas.set(i, p);
                break;
            }
        }
    }

    public void excluir(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica p : pessoas) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoas;
    }

    public void persistir(String nomeArquivo) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pessoas);
        oos.close();
    }

    public void recuperar(String nomeArquivo) throws Exception {
        FileInputStream fis = new FileInputStream(nomeArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        pessoas = (ArrayList<PessoaJuridica>) ois.readObject();
        ois.close();
    }
}