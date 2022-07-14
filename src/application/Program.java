package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.print("Numero do quarto: ");
			int roomNumber = scan.nextInt();
			System.out.print("Data de check-in (DD/MM/AAAA): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("Data de check-out (DD/MM/AAAA): ");
			Date checkOut = sdf.parse(scan.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Entre com os dados de autualização da reserva:");
			System.out.print("Data de check-in (DD/MM/AAAA): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Data de check-out (DD/MM/AAAA): ");
			checkOut = sdf.parse(scan.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);

		} catch (ParseException e) {
			System.out.println("Formato de data invalida!");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch(InputMismatchException e) {
			System.out.println("Numero do quarto invalido!");
		}

		scan.close();

	}
}
