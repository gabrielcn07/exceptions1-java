package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNunber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNunber, Date checkin, Date checkout) {
		this.roomNunber = roomNunber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date CheckOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro em atualizar reserva: as datas de atulização precisam ser datas futuras.";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro na reserva: o check-out deve ser uma data fututra ao check-in.";
		}
		this.checkIn = checkIn;
		this.checkOut = CheckOut;
		return null;
	}

	public Integer getRoomNunber() {
		return roomNunber;
	}

	public void setRoomNunber(Integer roomNunber) {
		this.roomNunber = roomNunber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	@Override
	public String toString() {
		return "Reserva: Quanto " + roomNunber + ", check-in: " + sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duration() + " noites";
	}

}
