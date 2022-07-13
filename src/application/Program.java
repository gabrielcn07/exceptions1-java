package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int roomNumber = scan.nextInt();
		System.out.print("Data de check-in (DD/MM/AAAA): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.print("Data de check-out (DD/MM/AAAA): ");
		Date checkOut = sdf.parse(scan.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: o check-out deve ser uma data fututra ao check-in.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Entre com os dados de autualização da reserva:");
			System.out.print("Data de check-in (DD/MM/AAAA): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Data de check-out (DD/MM/AAAA): ");
			checkOut = sdf.parse(scan.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro em atualizar reserva: as datas de atulização precisam ser datas futuras.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: o check-out deve ser uma data fututra ao check-in.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}

		}

		scan.close();

	}
}
