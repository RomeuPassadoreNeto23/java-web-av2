package br.senai.sp.lojaquiosque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.lojaquiosque.model.Cliente;
import br.senai.sp.lojaquiosque.model.FaixaEtaria;
import br.senai.sp.lojaquiosque.model.Genero;
import br.senai.sp.lojaquiosque.model.TelefoneOuCelular;
import br.senai.sp.lojaquiosque.model.TipoProduto;

public class DaoCliente {
	private Connection conexao;

	public DaoCliente() {
		conexao = ConnectionFactory.conectar();

	}
	public void inserir(Cliente cliente) {
		String sql = "insert into cliente(nome,endereco,contato,tptelefone,tprodutos,genero,faixa_etaria)  values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setInt(4, cliente.getTelefoneoucelular().ordinal());
			stmt.setString(5,cliente.getEmail());
			stmt.setInt(6,cliente.getTipoproduto().ordinal());
			stmt.setInt(7, cliente.getGenero().ordinal());
			stmt.setInt(8, cliente.getFaixaEtaria().ordinal());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		
	}
	public List<Cliente> listar() {
		String sql = "select * from tb_produto order by nome asc";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getInt("contato"));
				// cria um Calendar
				//Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				//Date dataBd = rs.getDate("data_validade");
				// "setar" a data do calendar pela data do Date
				//validade.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
			//	p.setDataValidade(validade);
				// extrair a posição da enumeração do resultset
				int posEnumn = rs.getInt("tptelefone");
				TelefoneOuCelular tele = TelefoneOuCelular.values()[posEnumn];
				c.setTelefoneoucelular(tele);
				
				int posEnum = rs.getInt("tipo_produto");
				
				// descobre a enumeração através da posição
				TipoProduto tipos = TipoProduto.values()[posEnum];
				// "setar" o tipo no produto
				c.setTipoproduto(tipos);
				int posEnumG = rs.getInt("genero");
				Genero gen = Genero.values()[posEnumG];
				c.setGenero(gen);
				int posEnumf = rs.getInt("faixa_etaria");
				FaixaEtaria faix = FaixaEtaria.values()[posEnumf];
				c.setFaixetaria(faix);
				
				
				lista.add(c);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
