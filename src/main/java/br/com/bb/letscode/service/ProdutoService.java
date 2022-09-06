package br.com.bb.letscode.service;

import br.com.bb.letscode.dto.ProdutoDto;
import br.com.bb.letscode.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    boolean novoProduto(ProdutoDto produto);

    List<Produto> listarProdutos();

    Optional<Produto> buscarProduto(long id);

    boolean atualizarProduto(Produto produto);

    boolean removerProduto(long id);

}
