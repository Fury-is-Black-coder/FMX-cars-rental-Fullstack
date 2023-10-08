# FMX-cars-rental-Fullstack

H2 DB: 
username=sa
password=""

![image](https://github.com/Fury-is-Black-coder/FMX-cars-rental-Fullstack/assets/57364788/9babeeef-72b1-4308-9607-725c0652a62c)

API Postman:
-----------------------------------------------------------
https://api.postman.com/collections/29614417-851d18ba-567c-49bd-b638-b1080eed769c?access_key=PMAT-01HC8SFY5AJSEG3TZW00EJQ3JZ

## **Schemat ogólny**

Frontend (interfejs użytkownika):
-----------------------------------------------------------
Aplikacja webowa lub mobilna umożliwiająca pracownikom rezerwację pojazdów.
Interfejs użytkownika do przeglądania dostępnych pojazdów, rezerwacji i zwrotu kluczyków.
Integracja z "FMX-ID" w celu uwierzytelnienia użytkowników.

Backend (logika biznesowa):
-----------------------------------------------------------
Kontrolery REST API obsługujące operacje związane z rezerwacją i zarządzaniem pojazdami.
Logika biznesowa do zarządzania rezerwacjami i dostępnością pojazdów.
Integracja z "FMX-ID" w celu uwierzytelnienia i autoryzacji użytkowników.

Baza danych:
-----------------------------------------------------------
Przechowuje informacje o dostępnych pojazdach, rezerwacjach, pracownikach itp.

Zarządzanie parkingiem:
-----------------------------------------------------------
Aplikacja do obsługi parkingu, która śledzi dostępność pojazdów, przyjmuje i zwraca kluczyki do pojazdów.

Integracja z "FMX-ID":
-----------------------------------------------------------
Uwierzytelnienie i autoryzacja pracowników za pomocą "FMX-ID".
Przepływ informacji o zalogowanych użytkownikach między "FMX-ID" a "FMX-cars".

Zarządzanie sesjami i uwierzytelnianie:
-----------------------------------------------------------
Sesje użytkowników w celu śledzenia ich stanu i autoryzacji.
Możliwość korzystania z tokenów JWT w celu zabezpieczenia komunikacji między frontendem a backendem.

Ważne jest, aby odpowiednio zabezpieczyć aplikację, dbając o prywatność danych pracowników oraz zapewniając łatwą i wygodną obsługę rezerwacji pojazdów.

-----------------------------------------------------------
RESTful API "FMX-cars":
API umożliwiające dostęp do funkcjonalności "FMX-cars" z innych aplikacji lub usług.
Obsługa operacji takich jak rezerwacja pojazdów, pobieranie dostępnych pojazdów, zwrot kluczyków, itp.
Wymagane uwierzytelnienie i autoryzacja przy użyciu tokenów JWT lub innych metod.
-----------------------------------------------------------

## **Proponowana architektura aplikacji:**

Encje (Entity):
-----------------------------------------------------------
CarEntity: Reprezentuje informacje o samochodach, w tym markę, model, numer rejestracyjny, stan dostępności itp.
UserEntity: Przechowuje dane użytkowników, takie jak imię, nazwisko, login, hasło itp.
ReservationEntity: Zawiera informacje o rezerwacjach, takie jak data rozpoczęcia i zakończenia rezerwacji, powiązanie z samochodem i użytkownikiem oraz informacje o zakończeniu rezerwacji.

Repozytoria (Repositories):
-----------------------------------------------------------
CarRepository: Interfejs repozytorium dla CarEntity, który umożliwia operacje na samochodach w bazie danych.
UserRepository: Interfejs repozytorium dla UserEntity, który umożliwia operacje na użytkownikach w bazie danych.
ReservationRepository: Interfejs repozytorium dla ReservationEntity, który umożliwia operacje na rezerwacjach w bazie danych.

Serwisy (Services):
-----------------------------------------------------------
CarService: Odpowiada za logikę biznesową związaną z samochodami, taką jak dodawanie samochodu, pobieranie dostępnych samochodów itp.
UserService: Zarządza użytkownikami, w tym tworzeniem nowych kont użytkowników.
ReservationService: Zarządza procesem rezerwacji samochodów, w tym tworzeniem, anulowaniem i zakończeniem rezerwacji.

Kontrolery (Controllers):
-----------------------------------------------------------
CarController: Obsługuje żądania dotyczące operacji na samochodach, takie jak pobieranie listy dostępnych samochodów, dodawanie nowego samochodu itp.
UserController: Obsługuje żądania związane z użytkownikami, takie jak rejestracja nowego użytkownika.
ReservationController: Zarządza rezerwacjami samochodów, w tym tworzeniem nowych rezerwacji, anulowaniem i zakończeniem.

Warstwa widoku (View Layer):
-----------------------------------------------------------
Warstwa ta obejmuje pliki HTML, które reprezentują interfejs użytkownika. Można użyć frameworka takiego jak Thymeleaf lub Angular w zależności od preferencji.

Baza danych:
-----------------------------------------------------------
Bazy danych (PostgreSQL) do przechowywania danych o samochodach, użytkownikach i rezerwacjach.

Zabezpieczenia:
-----------------------------------------------------------
Mechanizmy zabezpieczeń, takie jak uwierzytelnianie i autoryzacja, w zależności od wymagań projektu.

![image](https://github.com/Fury-is-Black-coder/FMX-cars-rental-Fullstack/assets/57364788/9babeeef-72b1-4308-9607-725c0652a62c)

API Postman:
-----------------------------------------------------------
https://api.postman.com/collections/29614417-851d18ba-567c-49bd-b638-b1080eed769c?access_key=PMAT-01HC8SFY5AJSEG3TZW00EJQ3JZ
