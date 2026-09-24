# API — Sistema de Booking de Mesas de Restaurante

## Tecnologias
- Java 17
- Spring Boot

## Endpoints levantados

| Ação | Método | Endpoint |
|---|---|---|
| Reservar | POST | `/api/v1/reservation` |
| Reagendar reserva | PUT | `/api/v1/reservation/{id}/reschedule` |
| Mostrar status da reserva | GET | `/api/v1/reservation/status` |
| Cancelar reserva | PUT | `/api/v1/reservation/{id}/cancel` |
| Verificar contato do reservante | POST | `/api/v1/reservation/{id}/verify` |
| Confirmar presença | PUT | `/api/v1/reservation/{id}/confirm` |
| Mostrar mesas cadastradas | GET | `/api/v1/table` |
| Mostrar mesas disponiveis | GET | `/api/v1/table/availability?date=&time=&people=` |
| Login no painel admin | — | `/api/v1/manager/auth/login` |
| Mostrar reservas | GET | `/api/v1/manager/reservation?start=&end=&status=` |
| Desativar mesa | PATCH | `/api/v1/manager/table/{id}/deactivate` |
| Cadastrar mesas | POST/PUT | `/api/v1/manager/table/register/` |
| Atualizar mesa | PUT | `/api/v1/manager/table/{id}` |

---
