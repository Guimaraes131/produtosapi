package io.github.Guimaraes131.produtosapi.repository;

import io.github.Guimaraes131.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
