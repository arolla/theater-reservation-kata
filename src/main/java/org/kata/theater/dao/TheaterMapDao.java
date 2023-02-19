package org.kata.theater.dao;

import org.kata.theater.Row;
import org.kata.theater.Seat;
import org.kata.theater.TheaterRoom;
import org.kata.theater.Zone;

import java.util.HashMap;
import java.util.Map;

public class TheaterMapDao {
    // simulates a room map/topology repository
    // move to TheaterRoomDao (mais sans interface et en instanciation directe) ?

    private Map<Long, TheaterRoom> theaterRoomMaps = new HashMap<>();

    public TheaterMapDao() {
        theaterRoomMaps.put(1L, fetchRoomForPerformance1());
    }

    public TheaterRoom fetchTheaterRoom(long performanceId) {
        return theaterRoomMaps.get(performanceId);
    }

    public void save(long id, TheaterRoom room) {
        theaterRoomMaps.put(id, room);
    }

    private static TheaterRoom fetchRoomForPerformance1() {
        // ici on sent venir l'utilité forte d'un TestDataBuilder, auquel on devrait passer pour chaque zone :
        // - la liste des préfixes de noms de rangées
        // - la liste du nombre de sièges par rangée
        // - la liste des noms de sièges réservés
        // - ex : Zone.builder()
        //            .withRows ("A", "B", "C", "D", "E", "F", "G")
        //             .withSeatCountPerRow(7, 8, 9, 9, 10, 10, 10)
        //              .withBookedSeats("A1", "A3", "A4", "B2")
        //              .build();

        // remarque : nous ne sommes pas la seule appli à pouvoir booker des places ce qui expliques les trous
        // entre des places réservées
        return new TheaterRoom( // pourrait être un Agregate
                new Zone[]{new Zone(new Row[]{
                        new Row(new Seat[]{
                                new Seat("A1", "BOOKED"), // smell : le statut est mélé à la topologie
                                new Seat("A2", "FREE"),
                                new Seat("A3", "BOOKED"),
                                new Seat("A4", "BOOKED"),
                                new Seat("A5", "FREE"),
                                new Seat("A6", "FREE"),
                                new Seat("A7", "FREE")
                        }),
                        new Row(new Seat[]{
                                new Seat("B1", "FREE"),
                                new Seat("B2", "BOOKED"),
                                new Seat("B3", "FREE"),
                                new Seat("B4", "FREE"),
                                new Seat("B5", "FREE"),
                                new Seat("B6", "FREE"),
                                new Seat("B7", "FREE"),
                                new Seat("B8", "FREE")
                        }),
                        new Row(new Seat[]{
                                new Seat("C1", "FREE"),
                                new Seat("C2", "FREE"),
                                new Seat("C3", "FREE"),
                                new Seat("C4", "FREE"),
                                new Seat("C5", "FREE"),
                                new Seat("C6", "FREE"),
                                new Seat("C7", "FREE"),
                                new Seat("C8", "FREE"),
                                new Seat("C9", "FREE")
                        }),
                        new Row(new Seat[]{
                                new Seat("D1", "FREE"),
                                new Seat("D2", "FREE"),
                                new Seat("D3", "FREE"),
                                new Seat("D4", "FREE"),
                                new Seat("D5", "FREE"),
                                new Seat("D6", "FREE"),
                                new Seat("D7", "FREE"),
                                new Seat("D8", "FREE"),
                                new Seat("D9", "FREE")
                        }),
                        new Row(new Seat[]{
                                new Seat("E1", "FREE"),
                                new Seat("E2", "FREE"),
                                new Seat("E3", "FREE"),
                                new Seat("E4", "FREE"),
                                new Seat("E5", "FREE"),
                                new Seat("E6", "FREE"),
                                new Seat("E7", "FREE"),
                                new Seat("E8", "FREE"),
                                new Seat("E9", "FREE"),
                                new Seat("E10", "FREE")
                        }),
                        new Row(new Seat[]{
                                new Seat("F1", "FREE"),
                                new Seat("F2", "FREE"),
                                new Seat("F3", "FREE"),
                                new Seat("F4", "FREE"),
                                new Seat("F5", "FREE"),
                                new Seat("F6", "FREE"),
                                new Seat("F7", "FREE"),
                                new Seat("F8", "FREE"),
                                new Seat("F9", "FREE"),
                                new Seat("F10", "FREE")
                        }),
                        new Row(new Seat[]{
                                new Seat("G1", "FREE"),
                                new Seat("G2", "FREE"),
                                new Seat("G3", "FREE"),
                                new Seat("G4", "FREE"),
                                new Seat("G5", "FREE"),
                                new Seat("G6", "FREE"),
                                new Seat("G7", "FREE"),
                                new Seat("G8", "FREE"),
                                new Seat("G9", "FREE"),
                                new Seat("G10", "FREE")
                        }
                        )
                })
                });
    }
}