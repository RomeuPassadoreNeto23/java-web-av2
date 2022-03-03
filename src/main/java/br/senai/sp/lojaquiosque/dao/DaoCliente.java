package br.senai.sp.lojaquiosque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.senai.sp.lojaquiosque.model.Cliente;
import br.senai.sp.lojaquiosque.model.Genero;
import br.senai.sp.lojaquiosque.model.TelefoneOuCelular;
import br.senai.sp.lojaquiosque.model.TipoProduto;

public class DaoCliente {
	private Connection conexao;

	public DaoCliente() {
		conexao = ConnectionFactory.conectar();

	}
	public void inserir(Cliente cliente) {
		String sql = "insert into tb_cliente(nome,endereco,contato,tptelefone,email,tprodutos,sex,faixa_etaria,eatacadastro)  values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement sl;
		try {
			sl = conexao.prepareStatement(sql);
			sl.setString(1, cliente.getNome());
			sl.setString(2, cliente.getEndereco());
			sl.setInt(3, cliente.getContato());
			sl.setInt(4, cliente.getTptelefone().ordinal());
			sl.setString(5,cliente.getEmail());
			sl.setInt(6,cliente.getTprodutos().ordinal());
			sl.setInt(7, cliente.getSex().ordinal());
			sl.setInt(8, cliente.getIdade());
			sl.setTimestamp(9, new Timestamp(cliente.getEatacadastro().getTimeInMillis()));
			//sl.setDate(9, new Date(cliente.getEatacadastro().getTimeInMillis()));
			sl.execute();
			sl.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		
	}
	public List<Cliente> listar() {
		String sql = "select * from tb_cliente order by nome asc";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setContato(rs.getInt("contato"));;
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
				c.setTptelefone(tele);
				c.setEmail(rs.getString("email"));
				
				int posEnum = rs.getInt("tprodutos");
				
				// descobre a enumeração através da posição
				TipoProduto tipos = TipoProduto.values()[posEnum];
				// "setar" o tipo no produto
				c.setTprodutos(tipos);
				int posEnumG = rs.getInt("sex");
				Genero gen = Genero.values()[posEnumG];
				c.setSex(gen);
				c.setIdade(rs.getInt("faixa_etaria"));
				// cria um Calendar
				  Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
				validade.setTimeInMillis( rs.getTimestamp("eatacadastro").getTime());
				c.setEatacadastro(validade);
				// "setar" a validade no produto
				
				
				
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
	public void excluir(long id) {
		String sql = "delete from tb_cliente where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void atualizar(Cliente cliente) {
		String sql = "update tb_cliente set nome = ?, "
				+ "endereco = ?, contato = ?,tptelefone = ?,email = ?,tprodutos = ?,sex = ?,faixa_etaria = ? where id = ? "
				;
		PreparedStatement stmt; 
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getContato());
            stmt.setInt(4, cliente.getTptelefone().ordinal());
			stmt.setString(5,cliente.getEmail());
			stmt.setInt(6,cliente.getTprodutos().ordinal());
			stmt.setInt(7, cliente.getSex().ordinal());
			stmt.setInt(8, cliente.getIdade());
			stmt.setLong(9, cliente.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}					
	}
	public Cliente buscar(long idcliente){
		String sql = "select * from tb_cliente where id = ?";
		Cliente c = null;
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idcliente);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setContato(rs.getInt("contato"));;
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
				c.setTptelefone(tele);
				c.setEmail(rs.getString("email"));
				
				int posEnum = rs.getInt("tprodutos");
				
				// descobre a enumeração através da posição
				TipoProduto tipos = TipoProduto.values()[posEnum];
				// "setar" o tipo no produto
				c.setTprodutos(tipos);
				int posEnumG = rs.getInt("sex");
				Genero gen = Genero.values()[posEnumG];
				c.setSex(gen);
				c.setIdade(rs.getInt("faixa_etaria"));
				// cria um Calendar
				  Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
				validade.setTimeInMillis( rs.getTimestamp("eatacadastro").getTime());
				c.setEatacadastro(validade);
				// "setar" a validade no produto
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return c;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> listargeneroh() {
		String sql = "SELECT sex FROM `tb_cliente` WHERE sex = 0";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				
				// cria um Calendar
				//Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				//Date dataBd = rs.getDate("data_validade");
				// "setar" a data do calendar pela data do Date
				//validade.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
			    //	p.setDataValidade(validade);
				// extrair a posição da enumeração do resultset
			
				
				
				
				// descobre a enumeração através da posição
				
				// "setar" o tipo no produto
				
				int posEnumG = rs.getInt("sex");
				Genero gen = Genero.values()[posEnumG];
				c.setSex(gen);
				
				// cria um Calendar
				
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
			
				// "setar" a validade no produto
				
				
				
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
	public List<Cliente> listargef() {
		String sql = "SELECT sex FROM `tb_cliente` WHERE sex = 1";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				
				// cria um Calendar
				//Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				//Date dataBd = rs.getDate("data_validade");
				// "setar" a data do calendar pela data do Date
				//validade.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
			//	p.setDataValidade(validade);
				// extrair a posição da enumeração do resultset
			
				
				
				
				// descobre a enumeração através da posição
				
				// "setar" o tipo no produto
				
				int posEnumG = rs.getInt("sex");
				Genero gen = Genero.values()[posEnumG];
				c.setSex(gen);
				
				// cria um Calendar
				
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
			
				// "setar" a validade no produto
				
				
				
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
	public List<Cliente> listaridade() {
		String sql = "SELECT faixa_etaria FROM `tb_cliente`";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				
				// cria um Calendar
				//Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				//Date dataBd = rs.getDate("data_validade");
				// "setar" a data do calendar pela data do Date
				//validade.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
			    //	p.setDataValidade(validade);
				// extrair a posição da enumeração do resultset
			
				
				
				
				// descobre a enumeração através da posição
				
				// "setar" o tipo no produto
				
				c.setIdade(rs.getInt("faixa_etaria"));
				
				// cria um Calendar
				
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
			
				// "setar" a validade no produto
				
				
				
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
	public List<Cliente> listarhora() {
		String sql = "SELECT eatacadastro FROM `tb_cliente`";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				
				// cria um Calendar
				//Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				//Date dataBd = rs.getDate("data_validade");
				// "setar" a data do calendar pela data do Date
				//validade.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
			    //	p.setDataValidade(validade);
				// extrair a posição da enumeração do resultset
			
				
				
				
				// descobre a enumeração através da posição
				
				// "setar" o tipo no produto
				
				Calendar validade = Calendar.getInstance();
				validade.setTimeInMillis( rs.getTimestamp("eatacadastro").getTime());
				c.setEatacadastro(validade);
				
				// cria um Calendar
				
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
			
				// "setar" a validade no produto
				
				
				
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
	public List<Cliente> listardia() {
		String sql = "SELECT eatacadastro FROM `tb_cliente`";
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				
				// cria um Calendar
				//Calendar validade = Calendar.getInstance();
				// extrair o Date do resultset
				//Date dataBd = rs.getDate("data_validade");
				// "setar" a data do calendar pela data do Date
				//validade.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
			    //	p.setDataValidade(validade);
				// extrair a posição da enumeração do resultset
			
				
				
				
				// descobre a enumeração através da posição
				
				// "setar" o tipo no produto
				
				Calendar validade = Calendar.getInstance();
				validade.setTimeInMillis( rs.getTimestamp("eatacadastro").getTime());
				c.setEatacadastro(validade);
				
				// cria um Calendar
				
				// extrair o Date do resultset
				
				// "setar" a data do calendar pela data do Date
			
				// "setar" a validade no produto
				
				
				
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
