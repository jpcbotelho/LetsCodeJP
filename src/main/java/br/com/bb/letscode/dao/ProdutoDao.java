package br.com.bb.letscode.dao;

import br.com.bb.letscode.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {

}
