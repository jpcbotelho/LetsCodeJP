package br.com.bb.letscode.service.impl;

import java.util.List;
import java.util.Optional;
import br.com.bb.letscode.dao.ProdutoDao;
import br.com.bb.letscode.dto.ProdutoDto;
import br.com.bb.letscode.models.Produto;
import org.springframework.stereotype.Service;
import br.com.bb.letscode.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoDao produtoDao;

    // Cria produto
    @Override
    public boolean novoProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getDescricao(), produtoDto.getPreco());
            produtoDao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Lista todos os produtos
    @Override
    public List<Produto> listarProdutos() {
        return produtoDao.findAll();
    }

    // Retorna produto por Id
    @Override
    public Optional<Produto> buscarProduto(long id) {
        return produtoDao.findById(id);
    }

    // Atualiza Produto
    @Override
    public boolean atualizarProduto(Produto produto) {
        try {
            produtoDao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Deleta produto por Id
    @Override
    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}