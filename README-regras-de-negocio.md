# Regras de Negócio — Sistema de Booking de Mesas de Restaurante

## Requisitos funcionais

### Usuário
- O usuário poderá fazer reserva.
- O usuário poderá verificar o status da reserva.
- O usuário poderá cancelar ou reagendar a reserva.
- O usuário poderá escolher uma mesa para reservar via interface gráfica, semelhante à de escolha de assentos no cinema.
- O usuário poderá informar para quantas pessoas será a reserva; o sistema deverá escolher automaticamente as mesas que melhor atendam à quantidade de pessoas.
- O usuário poderá ver suas reservas passadas
- O usuário poderá decidir qual horário registrar sua reserva

### Admin
- O admin poderá cadastrar mesas e a quantidade de pessoas por mesa.
- O admin poderá ver todas as mesas cadastradas.
- O admin poderá desativar mesas.
- O admin poderá ver a quantidade de reservas para o dia ou período de tempo.
- O admin poderá ver o histórico de reservas.
- O admin poderá ver reservas canceladas ou reagendadas.
- O admin poderá ver as informações de contato do reservante.

### Sistema
- A mesma mesa não pode ter duas reservas ativas em horários sobrepostos
- Se o usuário não confirmar presença após o lembrete a reserva é cancelada
- Uma reserva deve ser feita, no mínimo, 24 horas antes do compromisso
- Uma reserva, por padrão, deverá ter no máximo 2 horas
---

## Requisitos não funcionais
- As APIs precisam de um tempo médio de resposta de 200-400ms com carga de 500 a 1000 usuários.
- A classificação de reservas ativas, canceladas e reagendadas deve ser diferenciada visualmente por verde, vermelho e amarelo, respectivamente.
- Para confirmar uma reserva, um dos meios de contato do usuário deve ser validado.
- O sistema precisa ter autenticação para usuários Admin
- O sistema precisa ter rate limiting nas APIs públicas
- O sistema precisa criptografar quaisquer dados sensíveis do reservante
- O usuário precisa poder cancelar a reserva em 3 a 5 cliques.
- O sistema precisa notificar o usuário 1-3 dias antes da sua reserva, confirmando se ainda irá acontecer.
- O sistema irá utilizar canais como e-mail e SMS para notificar o usuário da confirmação da presença

