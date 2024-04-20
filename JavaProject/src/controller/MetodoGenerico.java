package controller;


public class MetodoGenerico {
    // Método genérico que recebe um parâmetro de qualquer tipo
    public <T> void meuMetodo(T parametro) {
        // Faça o que você precisa fazer com o parâmetro aqui
        System.out.println("O parâmetro recebido é: " + parametro);
    }

    public static void main(String[] args) {
        MetodoGenerico obj = new MetodoGenerico();

        // Chamando o método com diferentes tipos de parâmetros
        obj.meuMetodo(10); // Integer
        obj.meuMetodo("Olá"); // String
        obj.meuMetodo(3.14); // Double
    }
}
/*
        Estoque estoque = new Estoque();
        estoque.setVisible(true);
        
        dispose();*/