# Proyecto: Snake Game 🐍

Este proyecto implementa el clásico juego de Snake con Java. A continuación, se detallan las características y avances implementados en el juego.

---

## Funcionalidades Implementadas:

### 1. **Interfaz Gráfica** 🎮
La interfaz gráfica tiene los siguientes componentes:

- **Contadores de puntos y pérdidas** a la izquierda.
- **Contador de tiempo** a la derecha, que muestra un temporizador de 5 segundos.

![Interfaz Gráfica](https://github.com/user-attachments/assets/30cf5e48-7dd3-4e57-9725-a5b93880b95c)

---

### 2. **Botana con Apariciones Aleatorias** 🍏
- La **botana** es un **label** de tamaño 25x25 px.
- La botana **aparece y desaparece cada 5 segundos** en una **posición aleatoria dentro del panel de fondo**.

---

### 3. **Creación de la Clase `GameHelper`** 🧑‍💻
La clase **`GameHelper`** reside dentro del paquete **`com.artur.snake`** y tiene los siguientes métodos estáticos:

- **`getRandomNumber(min, max)`**: Devuelve un número aleatorio dentro de un rango específico.
- **`sleep(seconds)`**: Pausa la ejecución del juego durante un número de segundos.

Los métodos de `GameHelper` se utilizan en **`GameEngine`** para gestionar la lógica del juego.

> **Nota:** No olvides referenciar los commits con el **número del issue** correspondiente y trabajar en las **features (start y finish)**.

---

### 4. **Movimiento del Snake** 🐍
- El **snake** comienza en la **esquina superior izquierda**.
- Se mueve siguiendo la **posición del mouse**.
- Cuando el snake alcanza la botana, se **queda quieto**.
- El snake **no debe salirse del panel de fondo**.

---

### 5. **Comer Botanas y Crecer** 🍎
- Cuando el snake coma una botana:
  - La **botana desaparece** y aparece en una **nueva posición aleatoria**.
  - El **temporizador de 5 segundos se reinicia**.
  - El snake **crece** al comer la botana.

---

### 6. **Límites de Pantalla para el Movimiento del Snake** 📏
- El movimiento del snake está restringido dentro de los **límites de la pantalla**, evitando que se salga fuera del panel de fondo.

---

### 7. **Puntos** 🎯
- Cada vez que el snake coma una botana, **se incrementa 1 punto** en el contador de puntos.

---

### 8. **Muerte del Snake** 💀
- El snake **muere** cuando choca contra los **bordes** del panel.
- Al morir:
  - El juego **se reinicia**.
  - Los **puntos se restablecen a 0**.
  - El snake pierde todos los segmentos que haya ganado.
  - El contador de **pérdidas** se incrementa en 1.

---

### 9. **Sonidos** 🎶
El juego incluye los siguientes sonidos:

- **Sonido de fondo** que se reproduce durante la ejecución del juego.
- **Sonido cuando el snake come una botana**.
- **Sonido cuando el snake choca contra los bordes**.
- **Sonido cuando aparece una nueva botana**.

---

## Notas Importantes:
- Cada commit debe referenciar el **número del issue** correspondiente para facilitar el seguimiento de las tareas.
- Asegúrate de implementar las **features (start y finish)** correctamente en el código.

---

¡Gracias por revisar este proyecto! Si tienes alguna pregunta o sugerencia, no dudes en abrir un *issue*.
