import java.util.ArrayList;
public class Carrinho {
    private ArrayList<ItemCardapio> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        System.out.println("--- ITENS NO CARRINHO ---");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + ". " + itens.get(i));
        }
    }

    public void editarItem(int posicao, ItemCardapio novoItem) {
        if (posicao >= 0 && posicao < itens.size()) {
            itens.set(posicao, novoItem);
            System.out.println("Item editado com sucesso.");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public void removerItem(int posicao) {
        if (posicao >= 0 && posicao < itens.size()) {
            itens.remove(posicao);
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }
}
