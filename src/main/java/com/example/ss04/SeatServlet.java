    package com.example.ss04;

    import model.Seat;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import javax.servlet.ServletException;
    import javax.servlet.http.*;
    import javax.servlet.annotation.*;

    @WebServlet(name = "SeatServlet", value = "/seats")
    public class SeatServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        private List<Seat> getSeatList() {
            List<Seat> seatList = new ArrayList<>();
            seatList.add(new Seat("S01", "Ghế A1", 100.0, false));
            seatList.add(new Seat("S02", "Ghế A2", 100.0, true));
            seatList.add(new Seat("S03", "Ghế A3", 120.0, false));
            seatList.add(new Seat("S04", "Ghế A4", 120.0, true));
            seatList.add(new Seat("S05", "Ghế B1", 90.0, false));
            return seatList;
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Seat> seatList = getSeatList();
            request.setAttribute("seatList", seatList);
            request.getRequestDispatcher("/seats.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String[] selectedIds = request.getParameterValues("selectedSeats");
            double total = 0;

            if (selectedIds != null) {
                List<Seat> seatList = getSeatList();

                for (String sid : selectedIds) {
                    for (Seat s : seatList) {
                        if (s.getId().equals(sid)) {
                            total += s.getPrice();
                            break;
                        }
                    }
                }

                request.setAttribute("total", total);
                request.setAttribute("seatsSelected", true);
            } else {
                request.setAttribute("error", "Vui lòng chọn ít nhất một ghế trước khi thanh toán.");
            }
            request.getRequestDispatcher("/seats.jsp").forward(request, response);
        }
    }