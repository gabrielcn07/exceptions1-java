package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNunber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNunber, Date checkIn, Date checkOut) {
		if (checkIn.after(checkOut)) {
			throw new DomainException("Erro na reserva: o check-out deve ser uma data fututra ao check-in.");
		}
		this.roomNunber = roomNunber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Erro em atualizar reserva: as datas de atulização precisam ser datas futuras.");
		}
		if (checkIn.after(checkOut)) {
			throw new DomainException("Erro na reserva: o check-out deve ser uma data fututra ao check-in.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

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
