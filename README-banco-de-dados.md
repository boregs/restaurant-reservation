# Banco de Dados — Sistema de Booking de Mesas de Restaurante

## Tecnologias

- PostgreSQL

## Estrutura levantada

### Tabela `tables`
| Campo | Descrição |
|---|---|
| table_id | Identificador da mesa |
| capacity | Quantidade de pessoas que a mesa comporta |
| location | Indentifica se a mesa está na área externa ou interna |
| status | Ativa / Inativa |

### Tabela `bookings`
| Campo | Descrição |
|---|---|
| booking_id | Identificador do booking |
| customer_id | Identificador do reservante |
| uuid | UUID | 
| people_count | Quantidade de pessoas da reserva |
| booking_datetime | Data/hora do booking |
| created_at | Quando foi criada |
| updated_at | Quando foi atualizada |
| confirmed | Verifica se a reserva foi confirmada | 
| status | Verifica o status da reserva (ACTIVE, CANCELLED, RESCHEDULED) |

### Tabela `booking_tables`
| Campo | Descrição |
|---|---|
| fk_booking_id | Identifiacador da reserva |
| fk_table_id | Identificador da mesa |
| fk_customer_id | Identificador do reservante |

### Tabela `customers`
| Campo | Descrição |
|---|---|
| customer_id | Identificador do reservante |
| first_name | Nome |
| last_name | Sobrenome |
| email | E-mail |
| phone | Telefone |
| cpf | CPF |
| uuid | UUID |
| is_phone_verified | Se o telefone do reservante está verificado |
| is_email_verified | Se o email do reservante está verificado |
| created_at | Quando foi criado |

### Tabela `users`
| Campo | Descrição |
|---|---|
| user_id | Identificador do usuário do sistema | 
| first_name | Nome |
| last_name | Sobrenome |
| email | E-mail |
| password | Senha |
| uuid | UUID |
| created_at | Quando foi criado |
| updated_at | Quando foi atualizado |
| active | Usuário ativo ou não |
