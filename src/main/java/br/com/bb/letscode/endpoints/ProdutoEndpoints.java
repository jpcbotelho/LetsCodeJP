package br.com.bb.letscode.endpoints;

import br.com.bb.letscode.dto.ProdutoDto;
import br.com.bb.letscode.models.Produto;
import br.com.bb.letscode.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutoEndpoints {

    @Autowired
    ProdutoService produtoService;

    // Cria produto
    @RequestMapping(path = "/produto", method = RequestMethod.POST)
    public ResponseEntity<String> novoCliente(@RequestBody ProdutoDto produtoDto) {
        boolean OK = produtoService.novoProduto(produtoDto);
        if (OK) {
            return new ResponseEntity<String>("Produto criado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível criar o produto.", HttpStatus.BAD_REQUEST);
        }
    }

    // Lista todos os produtos
    @RequestMapping(path = "/produto", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    // Retorna produto por Id
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduto(@PathVariable long id) {
        Optional<Produto> produto = produtoService.buscarProduto(id);
        if (produto.isEmpty()) {
            return new ResponseEntity<String>("Produto não encontrado.", HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(produto);
        }
    }

    // Atualiza produto
    @RequestMapping(path = "/produto", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizarCliente(@RequestBody Produto produto) {
        boolean OK = produtoService.atualizarProduto(produto);
        if (OK) {
            return new ResponseEntity<String>("Produto atualizado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível atualizar o produto.", HttpStatus.BAD_REQUEST);
        }
    }

    // Deleta produto por Id
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removerCliente(@PathVariable long id) {
        boolean OK = produtoService.removerProduto(id);
        if (OK) {
            return new ResponseEntity<String>("Produto excluído com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Não foi possível excluir o produto.", HttpStatus.BAD_REQUEST);
        }
    }

}