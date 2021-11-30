package aplicacao;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.EstadoPedido;



public class Programa {

	public static void main(String[] args) throws ParseException {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("data Nascimento (DD/MM/YYYY): ");
		
		Date dataNascimento = sdf.parse(sc.next());
		
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Entre com Status do Pedido:");
		System.out.print("Estado: ");
		EstadoPedido estado = EstadoPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), estado, cliente);
		
		System.out.print("Quantos itens o pedido vai ter? ");
		int N = sc.nextInt();
		for (int i=1; i<=N; i++) {
			System.out.println("Entre com o item número #" + i );
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço do Produto: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();
			
			Produto produto = new Produto(productName, productPrice);
			
			ItemPedido ip = new ItemPedido(quantity, productPrice, produto);
			
			pedido.addItem(ip);	
		}
		
		System.out.println();
		System.out.println(pedido);
		
		sc.close();
	}

	}


