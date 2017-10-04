package br.inatel.pos.dm107.modelos;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.inatel.pos.dm107.util.LocalDateTimeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Entrega {

	private Long numeroPedido;
	private Long idCliente;
	private String nomeRecebedor;
	private String cpfRecebedor;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataRecebimento;

	public Entrega() {
	}

	public Entrega(Long numeroPedido, Long idCliente) {
		this.numeroPedido = numeroPedido;
		this.idCliente = idCliente;
	}

	public Entrega(Long numeroPedido, Long idCliente, String nomeRecebedor, String cpfRecebedor, LocalDateTime data) {
		this.numeroPedido = numeroPedido;
		this.idCliente = idCliente;
		this.nomeRecebedor = nomeRecebedor;
		this.cpfRecebedor = cpfRecebedor;
		this.dataRecebimento = data;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
	}

	public String getCpfRecebedor() {
		return cpfRecebedor;
	}

	public void setCpfRecebedor(String cpfRecebedor) {
		this.cpfRecebedor = cpfRecebedor;
	}

	public LocalDateTime getData() {
		return dataRecebimento;
	}

	public void setData(LocalDateTime data) {
		this.dataRecebimento = data;
	}
}
