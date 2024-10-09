package com.example.eldorado.service;

import com.example.eldorado.dto.CustomerDto;
import com.example.eldorado.dto.FlightDto;
import com.example.eldorado.dto.ReservationDto;
import com.example.eldorado.entity.Customer;
import com.example.eldorado.entity.Flight;
import com.example.eldorado.entity.Reservation;
import com.example.eldorado.mapper.CustomerMapper;
import com.example.eldorado.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.ReservationRepository;
import com.example.eldorado.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private ReservationMapper reservationMapper;
    private CustomerMapper customerMapper;

    @Autowired
    public ReservationServiceImp(ReservationRepository reservationRepository, CustomerRepository customerRepository, ReservationMapper reservationMapper, CustomerMapper customerMapper) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.reservationMapper = reservationMapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<ReservationDto> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDto> reservationDtos = new ArrayList<>();

        for (Reservation entity : reservations) {
            reservationDtos.add(reservationMapper.toDto(entity));
        }

        return reservationDtos;
    }

    @Override
    public Optional<ReservationDto> find(int id) {
        Optional<Reservation> reservations = reservationRepository.findById(id);

        Optional<ReservationDto> reservationDtos;

        reservationDtos = reservations.map(reservationMapper::toDto);
        return reservationDtos;
    }

    @Override
    public ReservationDto create(ReservationDto reservationDto) {
        Reservation reservationEntity = new Reservation();

        reservationEntity = reservationMapper.toEntity(reservationDto);
        reservationEntity = reservationRepository.save(reservationEntity);

        reservationDto = reservationMapper.toDto(reservationEntity);
        return reservationDto;
    }

    @Override
    public Optional<ReservationDto> update(int id, ReservationDto newReservationDto) {
        return reservationRepository.findById(id).map(ReservationInDB -> {
            ReservationInDB = reservationMapper.toEntity(newReservationDto);
            ReservationInDB = reservationRepository.save(ReservationInDB);

            return reservationMapper.toDto(ReservationInDB);
        });
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Optional<CustomerDto> findByIdCustomer(CustomerDto customerDto) {
        Integer id = customerDto.getId();

        Optional<Customer> customers = customerRepository.findById(id);

        return customers.map(customerMapper::toDto);    //reservationMapper::toDto = (customer) -> reservationMapper.toDto(customer)
    }

}
