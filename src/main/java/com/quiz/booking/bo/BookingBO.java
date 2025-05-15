package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;
import com.quiz.lesson06.service.BookmarkBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

    private final BookmarkBO bookmarkBO;
	
	@Autowired
	private BookingMapper bookingMapper;

    BookingBO(BookmarkBO bookmarkBO) {
        this.bookmarkBO = bookmarkBO;
    }

	// input: X
	// output: List
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, LocalDate date,
			int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber
	// output: Booking(있거나 null이거나)
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		// List 경우 있으면 [1, 2, 3] [1]   없으면 []
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
//		if (bookingList.isEmpty()) {
//			return null;
//		}
//		
//		// 비어있지 않으면 마지막칸 값을 꺼낸다
//		return bookingList.get(bookingList.size() - 1);
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}






